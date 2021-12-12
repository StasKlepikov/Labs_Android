package com.example.lab1
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId;

open class Result(
    @PrimaryKey var _id: ObjectId = ObjectId(),
    var _partition: String = "123",
    var plus: String = "",
    var minus: String = "",
    var multiply: String = "",
    var divide: String = ""
): RealmObject() {}
