package example.com.model

import org.bson.types.ObjectId

data class Person(
    var _id: ObjectId? = null,
    var document: String,
    var name: String
)
