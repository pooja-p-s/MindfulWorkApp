package com.poojaps.mindfulwork.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.poojaps.mindfulwork.data.local.entity.MoodEntity;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class MoodDao_Impl implements MoodDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<MoodEntity> __insertAdapterOfMoodEntity;

  public MoodDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfMoodEntity = new EntityInsertAdapter<MoodEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `moods` (`id`,`userId`,`moodDate`,`moodTs`,`emoji`,`label`,`createdAt`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final MoodEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getId());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getUserId());
        }
        if (entity.getMoodDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getMoodDate());
        }
        statement.bindLong(4, entity.getMoodTs());
        if (entity.getEmoji() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getEmoji());
        }
        if (entity.getLabel() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getLabel());
        }
        statement.bindLong(7, entity.getCreatedAt());
      }
    };
  }

  @Override
  public Object insert(final MoodEntity mood, final Continuation<? super Unit> $completion) {
    if (mood == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfMoodEntity.insert(_connection, mood);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getByDate(final String date,
      final Continuation<? super List<MoodEntity>> $completion) {
    final String _sql = "SELECT * FROM moods WHERE moodDate = ? ORDER BY moodTs DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, date);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfMoodDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "moodDate");
        final int _columnIndexOfMoodTs = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "moodTs");
        final int _columnIndexOfEmoji = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "emoji");
        final int _columnIndexOfLabel = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "label");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final List<MoodEntity> _result = new ArrayList<MoodEntity>();
        while (_stmt.step()) {
          final MoodEntity _item;
          final String _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _stmt.getText(_columnIndexOfId);
          }
          final String _tmpUserId;
          if (_stmt.isNull(_columnIndexOfUserId)) {
            _tmpUserId = null;
          } else {
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
          }
          final String _tmpMoodDate;
          if (_stmt.isNull(_columnIndexOfMoodDate)) {
            _tmpMoodDate = null;
          } else {
            _tmpMoodDate = _stmt.getText(_columnIndexOfMoodDate);
          }
          final long _tmpMoodTs;
          _tmpMoodTs = _stmt.getLong(_columnIndexOfMoodTs);
          final String _tmpEmoji;
          if (_stmt.isNull(_columnIndexOfEmoji)) {
            _tmpEmoji = null;
          } else {
            _tmpEmoji = _stmt.getText(_columnIndexOfEmoji);
          }
          final String _tmpLabel;
          if (_stmt.isNull(_columnIndexOfLabel)) {
            _tmpLabel = null;
          } else {
            _tmpLabel = _stmt.getText(_columnIndexOfLabel);
          }
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          _item = new MoodEntity(_tmpId,_tmpUserId,_tmpMoodDate,_tmpMoodTs,_tmpEmoji,_tmpLabel,_tmpCreatedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getBetweenDates(final String from, final String to,
      final Continuation<? super List<MoodEntity>> $completion) {
    final String _sql = "SELECT * FROM moods WHERE moodDate BETWEEN ? AND ? ORDER BY moodDate DESC, moodTs DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (from == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, from);
        }
        _argIndex = 2;
        if (to == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, to);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfMoodDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "moodDate");
        final int _columnIndexOfMoodTs = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "moodTs");
        final int _columnIndexOfEmoji = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "emoji");
        final int _columnIndexOfLabel = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "label");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final List<MoodEntity> _result = new ArrayList<MoodEntity>();
        while (_stmt.step()) {
          final MoodEntity _item;
          final String _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _stmt.getText(_columnIndexOfId);
          }
          final String _tmpUserId;
          if (_stmt.isNull(_columnIndexOfUserId)) {
            _tmpUserId = null;
          } else {
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
          }
          final String _tmpMoodDate;
          if (_stmt.isNull(_columnIndexOfMoodDate)) {
            _tmpMoodDate = null;
          } else {
            _tmpMoodDate = _stmt.getText(_columnIndexOfMoodDate);
          }
          final long _tmpMoodTs;
          _tmpMoodTs = _stmt.getLong(_columnIndexOfMoodTs);
          final String _tmpEmoji;
          if (_stmt.isNull(_columnIndexOfEmoji)) {
            _tmpEmoji = null;
          } else {
            _tmpEmoji = _stmt.getText(_columnIndexOfEmoji);
          }
          final String _tmpLabel;
          if (_stmt.isNull(_columnIndexOfLabel)) {
            _tmpLabel = null;
          } else {
            _tmpLabel = _stmt.getText(_columnIndexOfLabel);
          }
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          _item = new MoodEntity(_tmpId,_tmpUserId,_tmpMoodDate,_tmpMoodTs,_tmpEmoji,_tmpLabel,_tmpCreatedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
