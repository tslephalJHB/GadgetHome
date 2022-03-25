import 'dart:convert';
import 'dart:io';
import 'dart:typed_data';

import 'package:gadgethomeapp/models/user.dart';
import 'package:http/http.dart' as http;
import 'package:gadgethomeapp/constants/constants.dart';
import 'package:gadgethomeapp/models/ad.dart';

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

Future<List<Ad>> getAds() async {
  var response = await http.get(
    Uri.parse(API_URL + '/ads/posts'),
    headers: {
      HttpHeaders.authorizationHeader: 'authorization',
    },
  );

  print(response);

  if (response.statusCode == 200) {
    List adsList = jsonDecode(response.body);
    List<Ad> ads = [];

    for (int i = 0; i < adsList.length; ++i) {
      ads.add(Ad.fromJson(adsList[i]));

      response = await http.get(Uri.parse("$API_URL/images/${ads[i].id}"));

      Uint8List image = jsonDecode(response.body);
      ads[i].addImage(image);
    }

    return ads;
  } else {
    throw Exception('Failed to load ads');
  }
}

Future<List<Ad>> getAdsByKeyword(String keyword) async {
  var response = await http.get(
    Uri.parse(API_URL + '/ads/posts/key/' + keyword),
    headers: {
      HttpHeaders.authorizationHeader: 'authorization',
    },
  );

  print(response);

  if (response.statusCode == 200) {
    List adsList = jsonDecode(response.body);
    List<Ad> ads = [];

    for (int i = 0; i < adsList.length; ++i) {
      ads.add(Ad.fromJson(adsList[i]));

      response = await http.get(Uri.parse("$API_URL/images/${ads[i].id}"));

      Uint8List image = jsonDecode(response.body);
      ads[i].addImage(image);
    }

    return ads;
  } else {
    throw Exception('Failed to load ads');
  }
}

Future<Ad> getAd(int id) async {
  var response = await http.get(
    Uri.parse(API_URL + '/ads/posts/id/' + id.toString()),
    headers: {
      HttpHeaders.authorizationHeader: 'authorization',
    },
  );
  Ad ad;

  print(response);

  if (response.statusCode == 200) {
    ad = Ad.fromJson(jsonDecode(response.body));

    response =
        await http.get(Uri.parse(API_URL + '/images/images/' + id.toString()));

    List<Uint8List> images = jsonDecode(response.body);

    for (Uint8List image in images) {
      ad.addImage(image);
    }

    return ad;
  } else {
    throw Exception('Failed to load ad');
  }
}

Future<bool> addPost(Ad ad, String token) async {
  var response = await http.post(Uri.parse("$API_URL/ads/posts"),
      headers: {
        HttpHeaders.authorizationHeader: "bearer $token",
        "Content-Type": "application/json"
      },
      body: jsonEncode(ad.toJson()));

  print(response.body);

  // Ad adResponse = Ad.fromJson(jsonDecode(response.body));

  // for (Uint8List image in ad.images) {
  //   response = await http.post(Uri.parse("$API_URL/images/posts"),
  //       headers: {
  //         HttpHeaders.authorizationHeader: "bearer $token",
  //         "Content-Type": "application/json"
  //       },
  //       body: jsonEncode(image));
  // }

  if (response.statusCode == 200) {
    return jsonDecode(response.body);
  } else {
    throw Exception('Failed to post Ad');
  }
}
