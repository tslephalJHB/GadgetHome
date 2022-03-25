import 'package:flutter/material.dart';
import 'package:gadgethomeapp/component/customshape.dart';
import 'package:gadgethomeapp/controllers/userprovider.dart';
import 'package:gadgethomeapp/models/ad.dart';
import 'package:provider/src/provider.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  var scaffoldKey = GlobalKey<ScaffoldState>();
  late double _height;
  late double _width;

  bool isExpanded = false;

  Widget fab() {
    return FloatingActionButton.extended(
      elevation: 3,
      onPressed: () {},
      backgroundColor: Colors.orange[200],
      icon: const Icon(Icons.camera_alt),
      label: const Text(
        "Post AD",
        textAlign: TextAlign.center,
        style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold),
      ),
    );
  }

  @override
  void initState() {
    super.initState();
  }

  void emptyFunction() {}

  Widget labelsGrid() {
    return GridView.count(
      physics: const NeverScrollableScrollPhysics(),
      shrinkWrap: true,
      crossAxisCount: 4,
      children: <Widget>[
        electronicsLabel("assets/icons/apple_icon.png", "Apple", () {}),
        electronicsLabel("assets/icons/camera_icon.png", "Cameras", () {}),
        electronicsLabel(
            "assets/icons/cell_phone_icon.png", "Cell Phones", () {}),
        electronicsLabel("assets/icons/computer_icon.png", "Computers", () {}),
        electronicsLabel("assets/icons/laptop_icon.png", "Laptops", () {}),
        electronicsLabel("assets/icons/samsung_icon.png", "Samsung", () {}),
        electronicsLabel("assets/icons/tablet_icon.png", "Tablets", () {}),
        electronicsLabel("assets/icons/tv_icon.png", "Televisions", () {})
      ],
    );
  }

  Widget electronicsLabel(String path, String label, void Function() ontap) {
    return Column(
      children: <Widget>[
        GestureDetector(
          onTap: ontap,
          child: Image.asset(
            path,
            height: _height / 12,
            width: _width / 12,
          ),
        ),
        const SizedBox(
          height: 5,
        ),
        Flexible(
          child: Text(
            label,
            style: const TextStyle(fontSize: 13),
          ),
        ),
      ],
    );
  }

  Widget builAd(BuildContext context, int index, List<Ad> listItem) {
    Ad ad = listItem[index];
    return GestureDetector(
        onTap: () {
          //Navigator.of(context).pushNamed(DETAIL_UI);
          print("Routing to detail page");
        },
        child: ad.build(context));
  }

  Widget buildAdsList(List<Ad> ads) {
    return Container(
      height: _height / 4.25,
      //width: MediaQuery.of(context).size.width,
      child: ListView.builder(
        padding: const EdgeInsets.all(5),
        shrinkWrap: true,
        itemCount: ads.length,
        scrollDirection: Axis.horizontal,
        itemBuilder: (BuildContext context, index) {
          Ad ad = ads[index];
          return GestureDetector(
              onTap: () {
                //Navigator.of(context).pushNamed(DETAIL_UI);
                print("Routing to detail page");
              },
              child: ad.build(context));
        },
      ),
    );
  }

  Widget topicContainer(String topic, void Function() onTap) {
    return Container(
      margin: const EdgeInsets.only(left: 30, right: 30, top: 10),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget>[
          Text(topic, style: const TextStyle(fontSize: 16)),
          GestureDetector(
            onTap: onTap,
            child: Text(
              'Show all',
              style: TextStyle(
                color: Colors.orange[300],
              ),
            ),
          )
        ],
      ),
    );
  }

  Widget clip(double opacity, double denominator, CustomClipper<Path> clipper) {
    return Opacity(
      opacity: opacity,
      child: ClipPath(
        clipper: clipper,
        child: Container(
          height: _height / denominator,
          decoration: const BoxDecoration(
            gradient: LinearGradient(
              colors: [Colors.orange, Colors.pinkAccent],
            ),
          ),
        ),
      ),
    );
  }

  Widget clipShape() {
    return Stack(
      children: <Widget>[
        clip(0.75, 3, CustomShapeClipper()),
        clip(0.5, 3.5, CustomShapeClipper2()),
        clip(0.25, 3, CustomShapeClipper3()),
        Container(
          margin: EdgeInsets.only(left: 40, right: 40, top: _height / 3.75),
          child: Material(
            borderRadius: BorderRadius.circular(30.0),
            elevation: 8,
            child: Container(
              child: TextFormField(
                cursorColor: Colors.orange[200],
                keyboardType: TextInputType.text,
                decoration: InputDecoration(
                  contentPadding: const EdgeInsets.all(10),
                  prefixIcon:
                      Icon(Icons.search, color: Colors.orange[200], size: 30),
                  hintText: "What're you looking for?",
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(30.0),
                      borderSide: BorderSide.none),
                ),
              ),
            ),
          ),
        ),
        Container(
          margin: EdgeInsets.only(left: 20, right: 20, top: _height / 20),
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Opacity(
                opacity: 0.5,
                child: Container(
                  margin: const EdgeInsets.symmetric(vertical: 5),
                  child: GestureDetector(
                    onTap: () {
                      scaffoldKey.currentState!.openDrawer();
                    },
                    child: Image.asset(
                      'assets/images/menubutton.png',
                      height: _height / 40,
                    ),
                  ),
                ),
              ),
              Flexible(
                child: Container(
                  height: _height / 20,
                  padding: const EdgeInsets.only(left: 10, right: 10),
                  decoration: BoxDecoration(
                    color: Colors.black12,
                    shape: BoxShape.rectangle,
                    borderRadius: BorderRadius.circular(30),
                  ),
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: <Widget>[
                      GestureDetector(
                        onTap: () {
                          print('Editing location');
                        },
                        child: Icon(
                          Icons.edit_location,
                          color: Colors.white,
                          size: _height / 40,
                        ),
                      ),
                      const SizedBox(
                        width: 10,
                      ),
                      Flexible(
                        child: Text('Johannesburg',
                            style: TextStyle(
                                color: Colors.white, fontSize: _height / 50),
                            softWrap: false),
                      ),
                    ],
                  ),
                ),
              ),
              Opacity(
                opacity: 0.5,
                child: GestureDetector(
                  onTap: () {},
                  child: Icon(
                    Icons.notifications,
                    color: Colors.black,
                    size: _height / 30,
                  ),
                ),
              ),
            ],
          ),
        ),
      ],
    );
  }

  Widget drawer(String username, String email) {
    return Drawer(
      child: Column(
        children: <Widget>[
          Opacity(
            opacity: 0.75,
            child: Container(
              height: _height / 6,
              padding: EdgeInsets.only(top: _height / 20),
              decoration: const BoxDecoration(
                gradient: LinearGradient(
                  colors: [Colors.orange, Colors.pinkAccent],
                ),
              ),
              child: ListTile(
                leading: const CircleAvatar(
                  child: Icon(
                    Icons.person,
                    size: 40,
                    color: Colors.black,
                  ),
                  radius: 30,
                  backgroundColor: Colors.white,
                ),
                title: Text(username),
                subtitle: Text(
                  email,
                  style: const TextStyle(fontSize: 13),
                ),
                trailing: const Icon(
                  Icons.arrow_forward_ios,
                  color: Colors.black,
                ),
              ),
            ),
          ),
          const ListTile(
            leading: Icon(Icons.payment),
            title: Text("Orders & Payments"),
          ),
        ],
      ),
    );
  }

  Widget bottomNavBar() {
    return BottomAppBar(
      notchMargin: 4,
      shape: AutomaticNotchedShape(const RoundedRectangleBorder(),
          RoundedRectangleBorder(borderRadius: BorderRadius.circular(20))),
      child: Container(
        margin: const EdgeInsets.only(left: 50, right: 50),
        decoration: BoxDecoration(
            shape: BoxShape.rectangle, borderRadius: BorderRadius.circular(30)),
        child: Row(
          mainAxisSize: MainAxisSize.max,
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: <Widget>[
            IconButton(
              icon: const Icon(Icons.home),
              onPressed: () {},
            ),
            IconButton(
              icon: const Icon(Icons.message),
              onPressed: () {},
            )
          ],
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    _height = MediaQuery.of(context).size.height;
    _width = MediaQuery.of(context).size.width;

    final controller = context.watch<UserProvider>();

    return Scaffold(
      key: scaffoldKey,
      drawer: drawer(controller.user.userName, controller.user.email),
      bottomNavigationBar: bottomNavBar(),
      floatingActionButton: fab(),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,
      body: Container(
        height: _height,
        width: _width,
        child: SingleChildScrollView(
          child: Column(
            children: <Widget>[
              clipShape(),
              labelsGrid(),
              const Divider(),
              topicContainer("Cell-Phones", emptyFunction),
              buildAdsList(controller.getAdsByKey("cellphones")),
              const Divider(),
              topicContainer("Computers", emptyFunction),
              buildAdsList(controller.getAdsByKey("computer")),
              const Divider(),
              topicContainer("cellphones", emptyFunction),
              buildAdsList(controller.getAdsByKey("cellphones")),
            ],
          ),
        ),
      ),
    );
  }
}
