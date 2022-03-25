class User {
  String userName;

  String firstName;

  String lastName;

  String number;

  String email;

  String password;

  User(this.userName, this.firstName, this.lastName, this.number, this.email,
      this.password);

  factory User.fromJson(Map map) {
    return User(map["user_name"], map["first_name"], map["last_name"],
        map["number"], map["email"], map["password"]);
  }

  Map<String, String> toJson() {
    return {
      'user_name': userName,
      'first_name': firstName,
      'last_name': lastName,
      'number': number,
      'email': email,
      'password': password
    };
  }
}
