package example

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.InputArgument
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@DgsComponent
class ItemDataFetcher {
    private val data = listOf(
        Item("A", "Item A"),
        Item("B", "Item B"),
        Item("C", "Item C")
    )

    @DgsData(parentType = "Query", field = "items")
    fun items(
        @InputArgument("orderBy") orderBy: List<OrderByInput>?,
        @InputArgument("first") first: Int?,
        @InputArgument("offset") offset: Int?,
        dfe: DgsDataFetchingEnvironment
    ): ItemConnection {

        orderBy?.let {
            it.forEach {
                log.info("Item class: {}", it.javaClass)
            }
        }

        return ItemConnection(
            totalCount = data.size.toLong(),
            nodes = data
        )
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(ItemDataFetcher::class.java)
    }
}