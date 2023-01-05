package com.rio.instagram.model

import android.app.Application
import org.json.JSONObject
import java.nio.charset.Charset

/**
 * [JsonUtils] is the class that provides the functionality to access the json files in the assets
 * folder of the application. [JsonUtils] is a class(acts like a singleton class) with private
 * constructor which can be instanced using getJsonUtilsInstance() static method
 */
class JsonUtils private constructor(private val application: Application) {

    // keeping getJsonUtilsInstance method, jsonUtils variable static inorder to make it act like a
    // singleton class
    companion object{
        // keeping it as volatile in order to make it thread safe
        @Volatile
        private var jsonUtils:JsonUtils? = null

        /**
         * [getJsonUtilsInstance] is the method that returns the object of the [JsonUtils] class
         */
        fun getJsonUtilsInstance(application: Application):JsonUtils{
            synchronized(this){
                var instance = jsonUtils
                if(instance == null){
                    instance = JsonUtils(application)
                }
                jsonUtils = instance
                return instance
            }
        }
    }

    /**
     * [getJsonData] method that returns the [JSONObject] of the given jsonFile
     */
    fun getJsonData(filename:String): JSONObject{
        if(!filename.endsWith(".json"))
            throw FileFormatException()
        val jsonData = application.assets.open(filename)
        val charset: Charset = Charsets.UTF_8
        val size = jsonData.available()
        val buffer = ByteArray(size)
        jsonData.read(buffer)
        jsonData.close()
        return JSONObject(String(buffer, charset))
    }
}

/**
 * [FileFormatException] is thrown when the given file is not a JSON
 */
class FileFormatException(message:String="Required '.json' but found another"): Exception(message)
