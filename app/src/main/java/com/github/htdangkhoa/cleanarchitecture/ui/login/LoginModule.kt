package com.github.htdangkhoa.cleanarchitecture.ui.login

import com.github.htdangkhoa.cleanarchitecture.data.repository.auth.AuthRepository
import com.github.htdangkhoa.cleanarchitecture.data.repository.auth.AuthRepositoryImp
import com.github.htdangkhoa.cleanarchitecture.data.service.AppService
import com.github.htdangkhoa.cleanarchitecture.domain.auth.AuthUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LoginModule {
    val module = module {
        single(override = true) { provideAuthRepository(get()) }

        single(override = true) { provideAuthUseCase(get()) }

        viewModel { LoginViewModel(get()) }
    }

    private fun provideAuthRepository(appService: AppService): AuthRepository = AuthRepositoryImp(appService)

    private fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(authRepository)
}