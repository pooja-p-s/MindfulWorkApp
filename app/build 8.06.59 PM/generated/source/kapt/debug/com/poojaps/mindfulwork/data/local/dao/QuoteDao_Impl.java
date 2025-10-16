package com.poojaps.mindfulwork.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.poojaps.mindfulwork.data.local.entity.QuoteEntity;
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
public final class QuoteDao_Impl implements QuoteDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<QuoteEntity> __insertAdapterOfQuoteEntity;

  public QuoteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfQuoteEntity = new EntityInsertAdapter<QuoteEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `quotes` (`id`,`text`,`author`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final QuoteEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getText() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getText());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getAuthor());
        }
      }
    };
  }

  @Override
  public Object insertAll(final List<QuoteEntity> quotes,
      final Continuation<? super Unit> $completion) {
    if (quotes == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfQuoteEntity.insert(_connection, quotes);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<QuoteEntity>> $completion) {
    final String _sql = "SELECT * FROM quotes";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfText = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "text");
        final int _columnIndexOfAuthor = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "author");
        final List<QuoteEntity> _result = new ArrayList<QuoteEntity>();
        while (_stmt.step()) {
          final QuoteEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpText;
          if (_stmt.isNull(_columnIndexOfText)) {
            _tmpText = null;
          } else {
            _tmpText = _stmt.getText(_columnIndexOfText);
          }
          final String _tmpAuthor;
          if (_stmt.isNull(_columnIndexOfAuthor)) {
            _tmpAuthor = null;
          } else {
            _tmpAuthor = _stmt.getText(_columnIndexOfAuthor);
          }
          _item = new QuoteEntity(_tmpId,_tmpText,_tmpAuthor);
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
