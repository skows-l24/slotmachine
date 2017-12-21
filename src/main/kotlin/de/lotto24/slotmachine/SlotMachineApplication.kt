package de.lotto24.slotmachine

import org.reactivestreams.Publisher
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@EnableAutoConfiguration
@SpringBootApplication
class SlotMachineApplication

fun main(args: Array<String>) {
    // SpringApplication.run(SlotMachineApplication::class.java, *args)

    SpringApplicationBuilder()
            .sources(SlotMachineApplication::class.java)
            .initializers(beans {
                bean {
                    val optionRepository = ref<OptionRepository>()

                    val options: Publisher<Option> = listOf(
                            Option(name = "Team A", options = listOf("mmoeh", "dmasc", "jtodt")),
                            Option(name = "Team B", options = listOf("svoge", "skows", "srobe")),
                            Option(name = "Team Platform", options = listOf("elang", "bpahl", "amasc", "obolt")))
                            .toFlux()
                            .flatMap { optionRepository.save(it) }

                    optionRepository
                            .deleteAll()
                            .thenMany(options)
                            .thenMany(optionRepository.findAll())
                            .subscribe { println(it) }
                }
                bean {
                    router {
                        ("/option").nest {

                            val optionRepository = ref<OptionRepository>()
                            val searchPathId = "id"
                            val searchPathName = "name"

                            GET("/") { ServerResponse.ok().body(optionRepository.findAll()) }
                            GET("/{$searchPathId}") { ServerResponse.ok().body(optionRepository.findById(it.pathVariable(searchPathId))) }
                            GET("/name/{$searchPathName}") { ServerResponse.ok().body(optionRepository.findByName(it.pathVariable(searchPathName))) }
                            POST("/") { ServerResponse.ok().body(optionRepository.insert(it.bodyToMono(Option::class.java))) }
                        }
                        ("hello").nest {
                            GET("/") { ServerResponse.ok().body(listOf("Hello World!").toMono()) }
                        }
                    }
                }
            })
            .run(*args)
}

interface OptionRepository : ReactiveMongoRepository<Option, String> {
    fun findByName(name: String): Flux<Option>
}

@Document
data class Option(@Id var id: String? = null, val name: String, val options: List<String>)
