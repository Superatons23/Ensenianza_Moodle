package apps.moviles.enseanza

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import apps.moviles.enseanza.repository.Repository

class MainViewModelFactory(private val repository:Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}