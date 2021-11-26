package com.loansapp.main.repository;

import java.util.Map;

public interface ILoginService {
	Map<String, String> login(String email, String password);
}
