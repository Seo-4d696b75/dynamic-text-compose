package jp.co.yumemi.dynamictextsample.ui.section.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.dynamictextsample.R
import jp.co.yumemi.dynamictextsample.ui.theme.DynamicTextSampleTheme

@Composable
fun MessageSection(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Hello, Android!",
            style = MaterialTheme.typography.titleLarge,
        )
        Image(
            painter = painterResource(id = R.drawable.ic_android),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp)
                .padding(all = 10.dp),
        )
        Text(
            text = "This is a sample app, where displayed text can be changed dynamically.",
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview
@Composable
fun PreviewMessageSection() {
    DynamicTextSampleTheme {
        MessageSection()
    }
}