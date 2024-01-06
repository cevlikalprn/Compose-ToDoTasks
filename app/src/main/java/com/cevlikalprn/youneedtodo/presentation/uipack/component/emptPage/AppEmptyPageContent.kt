package com.cevlikalprn.youneedtodo.presentation.uipack.component.emptPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.presentation.theme.EMPTY_PAGE_ICON_SIZE
import com.cevlikalprn.youneedtodo.presentation.theme.MediumGray

@Composable
fun AppEmptyPageContent(
    painter: Painter = painterResource(id = R.drawable.ic_sad_face),
    label: String = stringResource(id = R.string.empty_page_label)
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.size(EMPTY_PAGE_ICON_SIZE),
            painter = painter,
            tint = MediumGray,
            contentDescription = EMPTY_STRING
        )
        Text(
            text = label,
            color = MediumGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }
}

@Composable
@Preview
private fun AppEmptyPageContentPreview() {
    AppEmptyPageContent()
}