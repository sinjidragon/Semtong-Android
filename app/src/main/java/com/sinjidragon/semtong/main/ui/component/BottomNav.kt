package com.sinjidragon.semtong.main.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.innerShadow
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard

@Composable
fun BottomNav(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize(1f),
        contentAlignment = Alignment.BottomCenter
    ){
    NavigationBar(
        modifier = Modifier
            .innerShadow(),
        containerColor = Color.White
    ){
        NavigationBarItem(
            selected = currentRoute(navController) == "give_me_money",
            onClick = { navController.navigate("give_me_money") },
            icon = {
                Column {
                    Icon(
                        painterResource(
                            id = R.drawable.give_me_money_icon
                        ),
                        contentDescription = "give_me_money",
                        modifier = Modifier
                            .size(21.dp)
                            .align(Alignment.CenterHorizontally),
                        tint = if (currentRoute(navController) == "give_me_money") mainColor else gray2
                        )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "지원금",
                        fontSize = 12.sp,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Medium,
                        color = if (currentRoute(navController) == "give_me_money") mainColor else gray2,
                    )

                }
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Transparent
            )
        )
        NavigationBarItem(
            selected = currentRoute(navController) == "semtong",
            onClick = { navController.navigate("semtong") },
            icon = {
                Column {
                    Icon(
                        painterResource(
                            id = R.drawable.semtong_icon
                        ),
                        contentDescription = "semtong",
                        modifier = Modifier
                            .size(21.dp)
                            .align(Alignment.CenterHorizontally),
                        tint = if (currentRoute(navController) == "semtong") mainColor else gray2
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "가계부",
                        fontSize = 12.sp,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Medium,
                        color = if (currentRoute(navController) == "semtong") mainColor else gray2,
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Transparent
            )
        )
        NavigationBarItem(
            selected = currentRoute(navController) == "home",
            onClick = { navController.navigate("home") },
            icon = {
                Column {
                    Icon(
                        painterResource(
                            id = R.drawable.home_icon
                        ),
                        contentDescription = "home",
                        modifier = Modifier
                            .size(21.dp)
                            .align(Alignment.CenterHorizontally),
                        tint = if (currentRoute(navController) == "home") mainColor else gray2
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "홈",
                        fontSize = 12.sp,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Medium,
                        color = if (currentRoute(navController) == "home") mainColor else gray2,
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Transparent
            )
        )
        NavigationBarItem(
            selected = currentRoute(navController) == "goal",
            onClick = { navController.navigate("goal") },
            icon = {
                Column {
                    Icon(
                        painterResource(
                            id = R.drawable.goal_icon
                        ),
                        contentDescription = "goal",
                        modifier = Modifier
                            .size(21.dp)
                            .align(Alignment.CenterHorizontally),
                        tint = if (currentRoute(navController) == "goal") mainColor else gray2
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "목표",
                        fontSize = 12.sp,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Medium,
                        color = if (currentRoute(navController) == "goal") mainColor else gray2,
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Transparent
            )
        )
        NavigationBarItem(
            selected = currentRoute(navController) == "profile",
            onClick = { navController.navigate("profile") },
            icon = {
                Column {
                    Icon(
                        painterResource(
                            id = R.drawable.profile_icon
                        ),
                        contentDescription = "profile",
                        modifier = Modifier
                            .size(21.dp)
                            .align(Alignment.CenterHorizontally),
                        tint = if (currentRoute(navController) == "profile") mainColor else gray2
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "프로필",
                        fontSize = 12.sp,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Medium,
                        color = if (currentRoute(navController) == "profile") mainColor else gray2,
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Transparent
            )
        )
    }
}
    }
fun currentRoute(navController: NavController): String?{
    return navController.currentBackStackEntry?.destination?.route
}
@Preview(showSystemUi = true)
@Composable
fun BottomNavPreview(){
    BottomNav(navController = NavController(context = LocalContext.current))
}
