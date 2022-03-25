import 'package:flutter/cupertino.dart';
import 'package:gadgethomeapp/apirequests/apirequests.dart';
import 'package:gadgethomeapp/models/ad.dart';
import 'package:gadgethomeapp/models/user.dart';

class UserProvider extends ChangeNotifier {
  late User user;
  late String token;
  late Future<bool> loggedIn;
  Map response = {};

  UserProvider();

  Future<bool> loginUser(String username, String password) {
    return login(username, password).then((value) {
      response.addAll(value);

      if (response["error"] == "false" && response["message"] == "Logged In") {
        user = User.fromJson(response["user"]);
        token = response["token"];
        return true;
      }
      return false;
    });
  }

  Future<bool> registerUser(User user) {
    this.user = user;
    Map response = {};
    return register(user).then((value) {
      response.addAll(value);

      if (response["error"] == "false" &&
          response["message"] == "Account created successfully") {
        token = response["token"];
        return true;
      }
      return false;
    });
  }

  List<Ad> getAllAds() {
    List<Ad> ads = [];
    getAds().then((value) {
      for (var ad in value) {
        ads.add(ad);
      }
    });
    return ads;
  }

  List<Ad> getAdsByKey(String keyword) {
    List<Ad> ads = [];
    getAdsByKeyword(keyword).then((value) {
      for (var ad in value) {
        ads.add(ad);
      }
    });
    return ads;
  }

  Ad? getAdId(int id) {
    Ad? ad;
    getAd(id).then((value) {
      ad = value;
    });

    return ad;
  }
}
