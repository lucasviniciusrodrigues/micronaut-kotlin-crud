package example.com.controller

import com.mongodb.client.result.InsertOneResult
import com.mongodb.client.result.UpdateResult
import example.com.model.Person
import example.com.service.MongoService
import io.micronaut.http.annotation.*
import io.netty.handler.codec.http.HttpResponseStatus.OK
import java.net.http.HttpResponse
import javax.inject.Inject

@Controller("crud/v1")
class CrudController(private val mongoService: MongoService) {

    @Get("/all")
    fun getAll(): List<Person> = mongoService.getAll()

    @Get("/{doc}")
    fun getBydoc(@PathVariable("doc") doc: String): Person = mongoService.getByDoc(doc)

    @Post()
    fun post(@Body body: Person): InsertOneResult = mongoService.insert(body)

    @Put("/{doc}")
    fun update(@PathVariable("doc") doc: String,
               @Body body: Person): UpdateResult = mongoService.update(doc, body)

    @Delete("/{doc}")
    fun delete(@PathVariable("doc") doc: String) = mongoService.delete(doc)

}