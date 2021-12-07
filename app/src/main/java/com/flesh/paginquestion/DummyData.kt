package com.flesh.paginquestion

import androidx.annotation.IntRange
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

class DummyData {

    companion object{
        class Data(val id : Int,val data:String)

       private fun theList():List<Data>{
            val data = mutableListOf<Data>()
            repeat(100){
                data.add(Data(it, "String $it"))
            }
            return data.toList()
        }
    }

    fun getPage(@IntRange(from = 0, to = 10) page:Int):List<Data>{
        val begin = 1 * page * 10
        val end = begin + 10
        val fullList = theList()
        val sub = fullList.subList(begin,end)
        return sub
    }

}

@Dao
interface DummyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<DummyData.Companion.Data>)

}