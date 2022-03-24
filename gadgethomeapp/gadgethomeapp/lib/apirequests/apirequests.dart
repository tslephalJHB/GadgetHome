import 'dart:convert';
import 'dart:io';

import 'package:gadgethomeapp/models/user.dart';
import 'package:http/http.dart' as http;
import 'package:gadgethomeapp/constants/constants.dart';
import 'package:gadgethomeapp/models/ad.dart';

Future<List<Ad>> getAds() async {
  final response = await http.get(
    Uri.parse(API_URL + '/posts'),
    headers: {
      HttpHeaders.authorizationHeader: 'authorization',
    },
  );

  if (response.statusCode == 200) {
    List adsList = jsonDecode(response.body);
    List<Ad> ads = [];

    for (var ad in adsList) {
      ads.add(Ad.fromJson(ad));
    }

    return ads;
  } else {
    throw Exception('Failed to load ads');
  }
}

Future<Map> login(String username, String password) async {
  final response = await http.post(Uri.parse(API_URL + '/auth/login'),
      headers: {
        HttpHeaders.authorizationHeader: 'authorization',
        "Content-Type": "application/json"
      },
      body: jsonEncode({'user_name': username, 'password': password}));

  print(response.body);

  if (response.statusCode == 200) {
    return jsonDecode(response.body);
  } else {
    throw Exception('Failed to login');
  }
}

Future<Map> register(User user) async {
  final response = await http.post(Uri.parse(API_URL + '/auth/register'),
      headers: {
        HttpHeaders.authorizationHeader: 'authorization',
        "Content-Type": "application/json"
      },
      body: jsonEncode(user.toJson()));

  print(response.body);

  if (response.statusCode == 200) {
    return jsonDecode(response.body);
  } else {
    throw Exception('Failed to login');
  }
}
