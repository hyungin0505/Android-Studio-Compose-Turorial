package com.example.namecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namecard.ui.theme.NamecardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NamecardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
                        NameCardTitle(title = stringResource(R.string.title), modifier = Modifier.fillMaxWidth())
                        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(top = 3.dp, bottom = 8.dp))
                        NameCardMain (modifier = Modifier)
                        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp, bottom = 3.dp))
                        NameCardCareer(modifier = Modifier)
                    }
                }
            }
        }
    }
}

// 상단 바
@Composable
fun NameCardTitle(title: String, modifier: Modifier = Modifier) {
    val imgNameCard = painterResource(R.drawable.guestcard)
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Image(
            painter = imgNameCard,
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .padding(3.dp)
        )
        Text(text = title, fontSize = 20.sp,)
    }
}

// 기본 정보 텍스트
@Composable
fun NameCardMainContent(content: String, @DrawableRes imageRes: Int) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)){
        val image = painterResource(id = imageRes)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .padding(end = 3.dp)
        )
        Text(text = content, fontSize = 16.sp, color = Color.Black.copy(alpha=0.5f))
    }
}

// 프로필 사진 & 기본 정보
@Composable
fun NameCardMain(modifier: Modifier = Modifier) {
    Row(modifier=modifier) {
        // 프로필 사진
        Column(modifier = Modifier.fillMaxWidth().weight(2f)) {
            val imgProfile = painterResource(R.drawable.profile)
            Image(
                painter = imgProfile,
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .border(1.dp, Color.Black.copy(alpha=0.5f))
            )
        }
        // 기본 정보
        Column(modifier = Modifier.fillMaxWidth().weight(3f)) {
            Column(modifier = Modifier.padding(start=5.dp, top=10.dp)) {
                // 이름, 국적
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)) {
                    Text(
                        text = stringResource(R.string.name),
                        fontSize = 25.sp,
                        modifier = Modifier
                            .padding(start=17.dp)
                    )
                    val koreaFlag = painterResource(R.drawable.south_korea)
                    Image(
                        painter = koreaFlag,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 7.dp)
                    )
                }
                // 전화번호
                NameCardMainContent(
                    content = stringResource(R.string.call),
                    imageRes = R.drawable.call
                )
                // 생년월일
                NameCardMainContent(
                    content = stringResource(R.string.birthday),
                    imageRes = R.drawable.birthday_cake
                )
                // 이메일
                NameCardMainContent(
                    content = stringResource(R.string.email),
                    imageRes = R.drawable.mail
                )
                // 블로그 주소
                NameCardMainContent(
                    content = stringResource(R.string.blog),
                    imageRes = R.drawable.blog
                )
            }
        }
    }
}

// 경력 텍스트
@Composable
fun CareerContent(content: String, detail: String, modifier:Modifier = Modifier) {
    Text(
        text=content,
        fontSize = 18.sp,
        color = Color.Black.copy(alpha=0.8f),
        modifier = Modifier
            .padding(start = 5.dp, top=10.dp)
    )
    Text(
        text=detail,
        fontSize = 14.sp,
        color = Color.Black.copy(alpha=0.7f),
        modifier = Modifier
            .padding(start = 5.dp, top=2.dp)
    )
}

// 경력 목록
@Composable
fun NameCardCareer(modifier: Modifier = Modifier) {
    Column() {
        LazyColumn() {
            items(1) { index ->
                // 학교
                Text(
                    text = "School",
                    fontSize = 23.sp,
                    color = Color.Black.copy(alpha = 0.9f),
                    modifier = Modifier
                        .padding(top = 5.dp, start = 5.dp)
                )
                CareerContent(content = "Donghwa HS", detail = "2021.03 ~ 2024.02")
                CareerContent(content = "Konkuk Univ.", detail = "2024.03 ~ 2025.01")
                CareerContent(content = "Choongang Univ.", detail = "2025.03 ~ ")
                // 활동
                Text(
                    text = "Activity",
                    fontSize = 23.sp,
                    color = Color.Black.copy(alpha = 0.9f),
                    modifier = Modifier
                        .padding(top = 40.dp, start = 5.dp)
                )
                CareerContent(content = "SecutityFACT", detail = "Konkuk Univ. Cyber Security Club\n2024.03 ~ 2025.01")
                CareerContent(content = "WhiteHat School 3rd", detail = "2025.03 ~ ")
                // 수상
                Text(
                    text = "Prize",
                    fontSize = 23.sp,
                    color = Color.Black.copy(alpha = 0.9f),
                    modifier = Modifier
                        .padding(top = 40.dp, start = 5.dp)
                )
                CareerContent(content = "프로그래밍 학력우수상", detail = "동화고등학교\n2022.07.26")
                CareerContent(content = "WHS 3rd TOP20", detail = "2025.06")
                // CTF
                Text(
                    text = "CTF",
                    fontSize = 23.sp,
                    color = Color.Black.copy(alpha = 0.9f),
                    modifier = Modifier
                        .padding(top = 40.dp, start = 5.dp)
                )
                CareerContent(content = "DiceCTF 2024 Quals / 390th", detail = "2024.02.5 ")
                CareerContent(content = "LA CTF 2024 / 339th", detail = "2024.02.19 ")
                CareerContent(content = "AmateursCTF 2024 / 189th", detail = "2024.04.10 ")
                CareerContent(content = "HSPACE May Space War Web / 8th", detail = "2024.05.10 ")
                CareerContent(content = "SecutiryFACT CTF w.Alkon / 6th", detail = "2024.11.15 ")
                CareerContent(content = "CYBERGON CTF_2024 / 149th", detail = "2024.12.2 ")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NameCardPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
            NameCardTitle(title = stringResource(R.string.title), modifier = Modifier.fillMaxWidth())
            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(top = 3.dp, bottom = 8.dp))
            NameCardMain (modifier = Modifier)
            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp, bottom = 3.dp))
            NameCardCareer(modifier = Modifier)
        }
    }
}