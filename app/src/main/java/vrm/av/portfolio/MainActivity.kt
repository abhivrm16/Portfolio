package vrm.av.portfolio

import android.media.Image
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vrm.av.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioTheme {
                // A surface container using the 'background' color from the theme
                Portfolio()

            }
        }
    }
}

@Composable
fun Portfolio() {

    val isOpen = remember{
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)) {

            Image(
                painter = painterResource(id = R.drawable.profile) , contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Abhishek Verma", style = TextStyle(
                color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
            ))

            Text(text = "Android Composable Developer", style = MaterialTheme.typography.labelSmall)

            Spacer(modifier = Modifier.height(12.dp))

            Row() {
                Image(painter = painterResource(id = R.drawable.instagram) , contentDescription =null,
                modifier = Modifier.size(18.dp)
                )
                Text(text = "/____morax",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            Row() {
                Image(painter = painterResource(id = R.drawable.github) , contentDescription =null,
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "/abhivrm16",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { isOpen.value = !isOpen.value }) {
                Text(text = "My Projects")

            }
            if(isOpen.value){
                LazyColumn{
                    items(getProjectList()){
                        ProjectItem(it)
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project:Project) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile) , contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.headlineSmall)
            Text(text = project.des, style = MaterialTheme.typography.bodySmall)

        }
    }

}


fun getProjectList():List<Project>{
    return listOf(
        Project(name = "Social Media App", des = "Connect with your friends"),
        Project(name = "Media Player App", des = "Listen music"),
        Project(name = "Gaming App", des = "God of war Ragnarok"),
        Project(name = "Social Media App", des = "Connect with your friends"),
        Project(name = "Media Player App", des = "Listen music"),
        Project(name = "Gaming App", des = "God of war Ragnarok"),
        Project(name = "Social Media App", des = "Connect with your friends"),
        Project(name = "Media Player App", des = "Listen music"),
        Project(name = "Gaming App", des = "God of war Ragnarok")
    )
}

data class Project(
    val name: String,val des:String
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioTheme {
        Greeting("Android")
    }
}