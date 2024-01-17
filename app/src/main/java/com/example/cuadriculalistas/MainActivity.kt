package com.example.cuadriculalistas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadriculalistas.data.DataSource
import com.example.cuadriculalistas.model.Topic
import com.example.cuadriculalistas.ui.theme.CuadriculaListasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaListasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuandriculaListaApp()
                }
            }
        }
    }
}

@Composable
fun CuandriculaListaApp() {
    ListaTopics(
        listaTopicss = DataSource.cargarImagenes(),
    )
}

@Composable
fun Cuadrante(topic: Topic, modifier: Modifier = Modifier) {
    Card() {
       Row() {
           Image(
               painter = painterResource(topic.imageResourceId1),
               contentDescription = topic.dato.toString(),
               modifier = Modifier
                   .height(68.dp)
                   .width(68.dp),
               contentScale = ContentScale.Crop
           )
           Column(modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))) {
               Text(
                   text = stringResource(id = topic.stringResourceId),
                   modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))

               )
               Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
               Row() {
                   Icon(
                       painter = painterResource(R.drawable.ic_grain),
                       contentDescription = null,
                       modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_small))
                   )
                   Text(text = "adios")
               }
           }
       }
    }
}


@Composable
fun ListaTopics(listaTopicss: List<Topic>,modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(listaTopicss) { topic ->
            Cuadrante(
                topic = topic,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CuadriculaListasTheme {
        CuandriculaListaApp()
    }
}