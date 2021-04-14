package example.com.service

import example.com.model.Person
import example.com.repository.MongoRepositoryLocal
import javax.inject.Singleton

@Singleton
class MongoService {

    var mongoRepository: MongoRepositoryLocal

    constructor(mongoRepository: MongoRepositoryLocal){
        this.mongoRepository = mongoRepository
    }

    fun getAll(): MutableList<Person> {
        return mongoRepository.findAll()
    }

    fun getById(id: String): Person {
        return mongoRepository.findById(id).get()
    }

    fun insert(body: Person): Person {
        return mongoRepository.insert(body)
    }

    fun update(body: Person): Person {
        return mongoRepository.insert(body)

    }

    fun delete(id: String) {
        return mongoRepository.deleteById(id)
    }
}