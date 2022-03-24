class User {
  String userName;

  String firstName;

  String lastName;

  String number;

  String email;

  String password;

  User(this.userName, this.firstName, this.lastName, this.number, this.email,
      this.password);

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
