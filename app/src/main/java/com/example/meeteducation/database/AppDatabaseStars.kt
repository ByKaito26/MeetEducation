import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.meeteducation.database.likes.LikeDao
import com.example.meeteducation.database.likes.likes

@Database(
    entities = [likes::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabaseStars : RoomDatabase() {
    abstract fun likeDao(): LikeDao  // Cambiado a minúscula "likeDao"

    companion object {
        @Volatile
        private var INSTANCE: AppDatabaseStars? = null

        fun getDatabase(context: Context): AppDatabaseStars {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabaseStars::class.java,
                    "app_database_stars"
                ).fallbackToDestructiveMigration()  // Permite la migración destructiva
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}
