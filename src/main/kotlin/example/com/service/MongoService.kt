package example.com.service

import com.mongodb.client.result.InsertOneResult
import com.mongodb.client.result.UpdateResult
import example.com.model.Person
import example.com.repository.MongoMicronautRepository
import javax.inject.Singleton

@Singleton
class MongoService(private val mongoRepository: MongoMicronautRepository) {

    fun getAll(): List<Person> = mongoRepository.findAll()

    fun getByDoc(doc: String): Person = mongoRepository.findByDoc(doc)!!

    fun insert(body: Person): InsertOneResult = mongoRepository.create(body)

    fun update(doc: String, body: Person): UpdateResult = mongoRepository.update(doc, body)

    fun delete(doc: String) = mongoRepository.deleteByDoc(doc)

}