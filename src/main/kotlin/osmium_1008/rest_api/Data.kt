package osmium_1008.rest_api

import java.sql.Timestamp;

data class Data(val dat: Int, val id: Int, val date: Timestamp = Timestamp(System.currentTimeMillis()))