package com.poojaps.mindfulwork.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity;
import java.lang.Class;
import java.lang.Long;
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
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class FocusSessionDao_Impl implements FocusSessionDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<FocusSessionEntity> __insertAdapterOfFocusSessionEntity;

  public FocusSessionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfFocusSessionEntity = new EntityInsertAdapter<FocusSessionEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `focus_sessions` (`id`,`userId`,`startTs`,`endTs`,`durationSec`,`completed`,`createdAt`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final FocusSessionEntity entity) {
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
        statement.bindLong(3, entity.getStartTs());
        if (entity.getEndTs() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getEndTs());
        }
        statement.bindLong(5, entity.getDurationSec());
        final int _tmp = entity.getCompleted() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getCreatedAt());
      }
    };
  }

  @Override
  public Object insert(final FocusSessionEntity session,
      final Continuation<? super Unit> $completion) {
    if (session == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfFocusSessionEntity.insert(_connection, session);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getBetween(final long from, final long to,
      final Continuation<? super List<FocusSessionEntity>> $completion) {
    final String _sql = "SELECT * FROM focus_sessions WHERE startTs >= ? AND startTs < ? ORDER BY startTs DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, from);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, to);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfStartTs = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "startTs");
        final int _columnIndexOfEndTs = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "endTs");
        final int _columnIndexOfDurationSec = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "durationSec");
        final int _columnIndexOfCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "completed");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final List<FocusSessionEntity> _result = new ArrayList<FocusSessionEntity>();
        while (_stmt.step()) {
          final FocusSessionEntity _item;
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
          final long _tmpStartTs;
          _tmpStartTs = _stmt.getLong(_columnIndexOfStartTs);
          final Long _tmpEndTs;
          if (_stmt.isNull(_columnIndexOfEndTs)) {
            _tmpEndTs = null;
          } else {
            _tmpEndTs = _stmt.getLong(_columnIndexOfEndTs);
          }
          final int _tmpDurationSec;
          _tmpDurationSec = (int) (_stmt.getLong(_columnIndexOfDurationSec));
          final boolean _tmpCompleted;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfCompleted));
          _tmpCompleted = _tmp != 0;
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          _item = new FocusSessionEntity(_tmpId,_tmpUserId,_tmpStartTs,_tmpEndTs,_tmpDurationSec,_tmpCompleted,_tmpCreatedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Flow<List<FocusSessionEntity>> recent(final int limit) {
    final String _sql = "SELECT * FROM focus_sessions ORDER BY startTs DESC LIMIT ?";
    return FlowUtil.createFlow(__db, false, new String[] {"focus_sessions"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, limit);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfStartTs = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "startTs");
        final int _columnIndexOfEndTs = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "endTs");
        final int _columnIndexOfDurationSec = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "durationSec");
        final int _columnIndexOfCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "completed");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final List<FocusSessionEntity> _result = new ArrayList<FocusSessionEntity>();
        while (_stmt.step()) {
          final FocusSessionEntity _item;
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
          final long _tmpStartTs;
          _tmpStartTs = _stmt.getLong(_columnIndexOfStartTs);
          final Long _tmpEndTs;
          if (_stmt.isNull(_columnIndexOfEndTs)) {
            _tmpEndTs = null;
          } else {
            _tmpEndTs = _stmt.getLong(_columnIndexOfEndTs);
          }
          final int _tmpDurationSec;
          _tmpDurationSec = (int) (_stmt.getLong(_columnIndexOfDurationSec));
          final boolean _tmpCompleted;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfCompleted));
          _tmpCompleted = _tmp != 0;
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          _item = new FocusSessionEntity(_tmpId,_tmpUserId,_tmpStartTs,_tmpEndTs,_tmpDurationSec,_tmpCompleted,_tmpCreatedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object deleteById(final String id, final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM focus_sessions WHERE id = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, id);
        }
        _stmt.step();
        return Unit.INSTANCE;
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
