import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.activity03.ui.theme.Activity03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    Activity03Theme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileTitle()
                ProfileImage()
                ProfileDescription()
            }
        }
    }
}

@Composable
fun ProfileTitle() {
    Text(
        text = "John Doe",
        modifier = Modifier.padding(all = 16.dp)
    )
}

@Composable
fun ProfileImage() {
    Icon(
        imageVector = Icons.Default.AccountCircle,
        contentDescription = "Profile Image",
        modifier = Modifier
            .padding(all = 16.dp)
            .size(120.dp)
    )
}

@Composable
fun ProfileDescription() {
    Text(
        text = "John Doe is a professional mobile app developer with extensive experience in designing and building high-quality Android applications. He specializes in modern technologies and focuses on delivering user-friendly and efficient solutions.",
        modifier = Modifier.padding(all = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}