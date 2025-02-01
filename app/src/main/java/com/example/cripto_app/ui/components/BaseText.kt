package com.example.cripto_app.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.cripto_app.R

@Composable
fun BaseText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 14.sp,
    color: Color = colorResource(id = R.color.white),
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.W600,
    textAlign: TextAlign = TextAlign.Start,
    textOverflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
) {
    return Text(
        text = text,
        fontSize = fontSize,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        minLines = minLines,
        modifier = modifier,
    )
}