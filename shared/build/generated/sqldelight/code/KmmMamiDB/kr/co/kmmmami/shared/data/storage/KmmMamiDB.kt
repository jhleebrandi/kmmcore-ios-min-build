package kr.co.kmmmami.shared.`data`.storage

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import kr.co.kmmmami.shared.`data`.storage.shared.newInstance
import kr.co.kmmmami.shared.`data`.storage.shared.schema

public interface KmmMamiDB : Transacter {
  public val kmmMamiDBQueries: KmmMamiDBQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = KmmMamiDB::class.schema

    public operator fun invoke(driver: SqlDriver): KmmMamiDB = KmmMamiDB::class.newInstance(driver)
  }
}
