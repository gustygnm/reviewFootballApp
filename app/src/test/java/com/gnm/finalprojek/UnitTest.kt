package com.gnm.finalprojek

import com.gnm.finalprojek.api.ApiRequest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
class UnitTest {
	@Test
	fun sendReqTest(){
		val request = mock(ApiRequest::class.java)
		val url="https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328"
		request.SendingReq(url)
		verify(request).SendingReq(url)
	}
}