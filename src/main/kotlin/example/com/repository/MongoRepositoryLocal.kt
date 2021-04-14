package example.com.repository

import example.com.model.Person
import org.springframework.data.mongodb.repository.MongoRepository
import javax.inject.Singleton

@Singleton
interface MongoRepositoryLocal : MongoRepository<Person, String> {
}