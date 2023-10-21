package com.myapp.superheros

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myapp.superheros.model.Hero

@Composable
fun HeroScreenList() {
}

@Composable
fun HeroDetailList(hero: Hero, modifier: Modifier = Modifier) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.clip(RoundedCornerShape(16.dp))) {
        Row(modifier= Modifier
            .height(72.dp)
            .padding(16.dp)) {
            Column {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun HeroDetailListPreview(){
    HeroDetailList(hero = Hero(R.string.hero1,R.string.description1,R.drawable.android_superhero1))
}