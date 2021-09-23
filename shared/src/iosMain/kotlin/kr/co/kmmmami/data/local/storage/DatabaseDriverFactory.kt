package kr.co.kmmmami.data.local.storage

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kr.co.kmmmami.shared.data.storage.KmmMamiDB

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(KmmMamiDB.Schema, "kmmmami.db")
    }
}