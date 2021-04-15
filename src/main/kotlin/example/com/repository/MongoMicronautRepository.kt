package example.com.repository

import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.InsertOneResult
import com.mongodb.client.result.UpdateResult
import example.com.model.Person
import javax.inject.Singleton

@Singleton
class MongoMicronautRepository(private val mongoClient: MongoClient) {

    fun create(person: Person): InsertOneResult =
        getCollection()
            .insertOne(person)

    fun findAll(): List<Person> =
        getCollection()
            .find()
            .toList()

    fun findByDoc(doc: String): Person? =
        getCollection()
            .find(
                Filters.eq("document", doc)
            )
            .toList()
            .firstOrNull()

    fun update(doc: String, update: Person): UpdateResult =
        getCollection()
            .replaceOne(
                Filters.eq("document", doc),
                update
            )

    fun deleteByDoc(doc: String): DeleteResult =
        getCollection()
            .deleteOne(
                Filters.eq("document", doc)
            )

    private fun getCollection() =
        mongoClient
            .getDatabase("myDatabase")
            .getCollection("persons", Person::class.java)

}