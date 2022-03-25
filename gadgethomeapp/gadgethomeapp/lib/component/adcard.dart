import 'package:flutter/material.dart';

class AdCard extends StatelessWidget {
  late double _width;
  late double _height;
  String title;
  String price;
  String dateAdded;
  String category;
  String description;
  Image image;
  String location;

  AdCard(this.title, this.price, this.dateAdded, this.category,
      this.description, this.image, this.location,
      {Key? key})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    _width = MediaQuery.of(context).size.width;
    _height = MediaQuery.of(context).size.height;
    return Card(
      elevation: 3,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16.0)),
      color: Colors.white,
      child: Container(
        padding: const EdgeInsets.only(left: 10, top: 10, right: 5, bottom: 10),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Text(
                  title,
                  style: TextStyle(
                      fontWeight: FontWeight.bold, fontSize: _height / 40),
                ),
                Container(
                  width: _width / 2.75,
                  padding: const EdgeInsets.only(top: 5),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: <Widget>[
                      Flexible(
                        child: Text(
                          price,
                          style: const TextStyle(
                            fontSize: 16,
                          ),
                        ),
                      ),
                      Flexible(
                        child: Container(
                          padding: const EdgeInsets.all(2),
                          color: Colors.grey[200],
                          child: Text(
                            category,
                            softWrap: true,
                            style: const TextStyle(fontSize: 10),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                const SizedBox(
                  height: 5,
                ),
                Flexible(
                  child: Container(
                      width: _width / 2.5,
                      child: Text(
                        description,
                        style: TextStyle(
                          fontSize: _height / 70,
                        ),
                        maxLines: 2,
                        overflow: TextOverflow.ellipsis,
                        softWrap: true,
                      )),
                ),
                const SizedBox(
                  height: 10,
                ),
                Flexible(
                  child: Container(
                    width: _width / 2.75,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: <Widget>[
                        Flexible(
                          child: GestureDetector(
                            child: Icon(
                              Icons.favorite_border,
                              size: _height / 30,
                            ),
                            onTap: () {
                              print('Fav');
                            },
                          ),
                        ),
                        Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: <Widget>[
                            Text(
                              dateAdded,
                              style: TextStyle(fontSize: _height / 65),
                            ),
                            Row(
                              mainAxisSize: MainAxisSize.min,
                              children: <Widget>[
                                Icon(
                                  Icons.location_on,
                                  size: _height / 65,
                                ),
                                Text(
                                  location,
                                  style: TextStyle(fontSize: _height / 65),
                                )
                              ],
                            ),
                          ],
                        ),
                      ],
                    ),
                  ),
                ),
              ],
            ),
            const SizedBox(
              width: 10,
            ),
            Container(
              width: _width / 2.5,
              decoration: BoxDecoration(
                shape: BoxShape.rectangle,
                color: Colors.orange[50],
                borderRadius: BorderRadius.circular(10),
              ),
              padding: const EdgeInsets.all(10),
              child: image,
            ),
          ],
        ),
      ),
    );
  }
}
