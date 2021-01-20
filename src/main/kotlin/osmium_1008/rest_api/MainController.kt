package osmium_1008.rest_api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(val mainRepository: MainRepository) {
    @PostMapping("/postData")
    fun postData(@RequestBody data: Data): Int {
        val ret = mainRepository.isMax(data)
        mainRepository.push(data)
        return if (ret) {
            1
        } else {
            0
        }
    }

    @GetMapping("/getData")
    fun getData(): List<Data>{
        return mainRepository.getAll()
    }
}