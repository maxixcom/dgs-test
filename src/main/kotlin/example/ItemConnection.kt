package example

data class ItemConnection(
    val totalCount: Long? = 0,
    val nodes: List<Item>? = listOf()
)
