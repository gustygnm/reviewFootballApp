package com.gnm.finalprojek.data.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DataBaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "BOOKMARK.db", null, 1) {
    companion object {
        var instance: DataBaseHelper? = null
        @Synchronized
        fun getInstance(ctx: Context): DataBaseHelper {
            if (instance == null) {
                instance = DataBaseHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable("TB_BOOKMARK", true,
                "ID" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "EventId" to TEXT,
                "homeID" to TEXT,
                "awayID" to TEXT,
                "home" to TEXT,
                "away" to TEXT,
                "homeScore" to TEXT,
                "awayScore" to TEXT,
                "date" to TEXT)
        db.createTable("TB_TEAMS", true,
                "ID" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "TeamsID" to TEXT, "TeamsName" to TEXT, "TeamsDesc" to TEXT, "TeamPic" to TEXT
                , "TeamStadium" to TEXT, "TeamYear" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable("TB_BOOKMARK", true)
        db.dropTable("TB_TEAMS")
    }
}

val Context.database: DataBaseHelper get() = DataBaseHelper.getInstance(applicationContext)