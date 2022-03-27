import 'package:flutter/material.dart';
import 'package:gadgethome/constants/constants.dart';
import 'package:gadgethome/controllers/userprovider.dart';
import 'package:gadgethome/screens/homepage.dart';
import 'package:gadgethome/screens/login.dart';
import 'package:gadgethome/screens/register.dart';
import 'package:gadgethome/screens/splashscreen.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (context) => UserProvider(),
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Gadget Home',
      theme: ThemeData(
        primaryColor: Colors.orange,
        scaffoldBackgroundColor: Colors.white,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      routes: <String, WidgetBuilder>{
        MAIN_UI: (BuildContext context) => const HomePage(),
        LOGIN_SCREEN: (BuildContext context) => const LoginScreen(),
        REGISTRATION_SCREEN: (BuildContext context) => const RegisterScreen(),
        SPLASH_SCREEN: (BuildContext context) => const AnimatedSplashScreen(),
      },
      initialRoute: SPLASH_SCREEN,
    );
  }
}
