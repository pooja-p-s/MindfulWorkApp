package com.poojaps.mindfulwork.data.local.db;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.poojaps.mindfulwork.data.local.dao.FocusSessionDao;
import com.poojaps.mindfulwork.data.local.dao.FocusSessionDao_Impl;
import com.poojaps.mindfulwork.data.local.dao.MoodDao;
import com.poojaps.mindfulwork.data.local.dao.MoodDao_Impl;
import com.poojaps.mindfulwork.data.local.dao.QuoteDao;
import com.poojaps.mindfulwork.data.local.dao.QuoteDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile FocusSessionDao _focusSessionDao;

  private volatile MoodDao _moodDao;

  private volatile QuoteDao _quoteDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(1, "9ce1e5fa411f7abb7c25fe648f1a735e", "f81d599d2fffa0c8a9156e09e40188a1") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `focus_sessions` (`id` TEXT NOT NULL, `userId` TEXT, `startTs` INTEGER NOT NULL, `endTs` INTEGER, `durationSec` INTEGER NOT NULL, `completed` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `moods` (`id` TEXT NOT NULL, `userId` TEXT, `moodDate` TEXT NOT NULL, `moodTs` INTEGER NOT NULL, `emoji` TEXT NOT NULL, `label` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `quotes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `text` TEXT NOT NULL, `author` TEXT)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9ce1e5fa411f7abb7c25fe648f1a735e')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `focus_sessions`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `moods`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `quotes`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsFocusSessions = new HashMap<String, TableInfo.Column>(7);
        _columnsFocusSessions.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFocusSessions.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFocusSessions.put("startTs", new TableInfo.Column("startTs", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFocusSessions.put("endTs", new TableInfo.Column("endTs", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFocusSessions.put("durationSec", new TableInfo.Column("durationSec", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFocusSessions.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFocusSessions.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysFocusSessions = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesFocusSessions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFocusSessions = new TableInfo("focus_sessions", _columnsFocusSessions, _foreignKeysFocusSessions, _indicesFocusSessions);
        final TableInfo _existingFocusSessions = TableInfo.read(connection, "focus_sessions");
        if (!_infoFocusSessions.equals(_existingFocusSessions)) {
          return new RoomOpenDelegate.ValidationResult(false, "focus_sessions(com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity).\n"
                  + " Expected:\n" + _infoFocusSessions + "\n"
                  + " Found:\n" + _existingFocusSessions);
        }
        final Map<String, TableInfo.Column> _columnsMoods = new HashMap<String, TableInfo.Column>(7);
        _columnsMoods.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMoods.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMoods.put("moodDate", new TableInfo.Column("moodDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMoods.put("moodTs", new TableInfo.Column("moodTs", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMoods.put("emoji", new TableInfo.Column("emoji", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMoods.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMoods.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysMoods = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesMoods = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMoods = new TableInfo("moods", _columnsMoods, _foreignKeysMoods, _indicesMoods);
        final TableInfo _existingMoods = TableInfo.read(connection, "moods");
        if (!_infoMoods.equals(_existingMoods)) {
          return new RoomOpenDelegate.ValidationResult(false, "moods(com.poojaps.mindfulwork.data.local.entity.MoodEntity).\n"
                  + " Expected:\n" + _infoMoods + "\n"
                  + " Found:\n" + _existingMoods);
        }
        final Map<String, TableInfo.Column> _columnsQuotes = new HashMap<String, TableInfo.Column>(3);
        _columnsQuotes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuotes.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuotes.put("author", new TableInfo.Column("author", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysQuotes = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesQuotes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuotes = new TableInfo("quotes", _columnsQuotes, _foreignKeysQuotes, _indicesQuotes);
        final TableInfo _existingQuotes = TableInfo.read(connection, "quotes");
        if (!_infoQuotes.equals(_existingQuotes)) {
          return new RoomOpenDelegate.ValidationResult(false, "quotes(com.poojaps.mindfulwork.data.local.entity.QuoteEntity).\n"
                  + " Expected:\n" + _infoQuotes + "\n"
                  + " Found:\n" + _existingQuotes);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "focus_sessions", "moods", "quotes");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "focus_sessions", "moods", "quotes");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(FocusSessionDao.class, FocusSessionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MoodDao.class, MoodDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(QuoteDao.class, QuoteDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public FocusSessionDao focusSessionDao() {
    if (_focusSessionDao != null) {
      return _focusSessionDao;
    } else {
      synchronized(this) {
        if(_focusSessionDao == null) {
          _focusSessionDao = new FocusSessionDao_Impl(this);
        }
        return _focusSessionDao;
      }
    }
  }

  @Override
  public MoodDao moodDao() {
    if (_moodDao != null) {
      return _moodDao;
    } else {
      synchronized(this) {
        if(_moodDao == null) {
          _moodDao = new MoodDao_Impl(this);
        }
        return _moodDao;
      }
    }
  }

  @Override
  public QuoteDao quoteDao() {
    if (_quoteDao != null) {
      return _quoteDao;
    } else {
      synchronized(this) {
        if(_quoteDao == null) {
          _quoteDao = new QuoteDao_Impl(this);
        }
        return _quoteDao;
      }
    }
  }
}
