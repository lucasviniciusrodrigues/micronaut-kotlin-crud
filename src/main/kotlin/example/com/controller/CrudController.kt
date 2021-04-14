package example.com.controller

import example.com.model.Person
import example.com.service.MongoService
import io.micronaut.http.annotation.*
import io.netty.handler.codec.http.HttpResponseStatus.OK
import java.net.http.HttpResponse
import javax.inject.Inject

@Controller("crud/v1")
class CrudController {

    private var mongoService: MongoService

    @Inject
    constructor(mongoService: MongoService){
        this.mongoService = mongoService
    }

    @Get("/all")
    fun getAll(): MutableList<Person> {
        return mongoService.getAll()
    }

    @Get("{id}")
    fun getById(@Header("id") id: String): Person {
        return mongoService.getById(id)
    }


    @Post()
    fun post(@Body body: Person): Person {
        return mongoService.insert(body)
    }


    @Put()
    fun update(@Body body: Person): Person {
        return mongoService.update(body)
    }


    @Delete("{id}")
    fun delete(@Header("id") id: String) {
        mongoService.delete(id)
    }

}