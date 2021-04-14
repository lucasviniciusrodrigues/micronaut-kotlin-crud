package example.com.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Person(
    @Id
    val document: String,
    val name: String
)
