package com.nexora.browser.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexora.browser.data.Website
import com.nexora.browser.ui.components.SearchBar
import com.nexora.browser.ui.components.ShortcutItem

@Composable
fun HomeScreen() {
    var searchQuery by remember {
        mutableStateOf("")
    }
    val websites = listOf(
        Website("Google", "https://www.google.com"),
        Website("YouTube", "https://www.youtube.com"),
        Website("GitHub", "https://github.com"),
        Website("Reddit", "https://www.reddit.com"),
        Website("Wikipedia", "https://www.wikipedia.org")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0E12))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // App Brand Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "NEXORA",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF60A5FA),
                    letterSpacing = 2.sp
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Welcome / Prompt
            Text(
                text = "What would you like to explore?",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Search Bar
            SearchBar(
                query = searchQuery,
                onQueryChange = {
                    searchQuery = it
                },
                onSearch = { _ ->
                    // Browser navigation will be implemented later.
                }
            )

            Spacer(modifier = Modifier.height(36.dp))

            // Quick Access Section
            Text(
                text = "Quick Access",
                color = Color(0xFF9CA3AF),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(websites) { website ->
                    ShortcutItem(
                        websiteName = website.name,
                        onClick = {
                            // Browser navigation will be implemented later.
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            // Recently Visited Section Header
            Text(
                text = "Recent Activity",
                color = Color(0xFF9CA3AF),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1E2026)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "No recent browsing history",
                        color = Color(0xFF6B7280),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
