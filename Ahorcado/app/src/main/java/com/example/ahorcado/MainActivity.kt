import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.ahorcado.R

abstract class MainActivity : AppCompatActivity()
{
    protected fun setupToolbar()
    {
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}