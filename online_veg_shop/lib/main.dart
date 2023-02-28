import 'package:flutter/material.dart';

// constants start

// colors
const Color appBarColor = Colors.lightBlueAccent;
const Color backGroundColor = Color.fromRGBO(245, 245, 245, 1);
const Color headColor = Colors.white;
const Color normalColor = Color.fromRGBO(192, 218, 194, 1);
const Color dividerColors = Colors.tealAccent;
const Color tabColor = Colors.black;
const Color tabTextHideColor = Colors.white38;
const Color tabTextColor = Colors.brown;
const Color amtIncColor = Colors.pinkAccent;

//text
const String headName = 'Online Shop';
const FontWeight headWight = FontWeight.bold;
const double headFontSize = 0.07;
const String dummyDesc = 'vegetable, in the broadest sense, '
    'any kind of plant life or plant product, namely “vegetable '
    'matter”; in common, narrow usage, the term vegetable '
    'usually refers to the fresh edible portions of certain '
    'herbaceous plants—roots, stems, leaves, flowers, fruit, or '
    'seeds. These plant parts are either eaten fresh or prepared '
    'in a number of ways, usually as a savory, rather than sweet, dish.';
const String imgUrl = 'https://clipground.com/images/vegetales-png-5.png';

//size

const double elevationSize = 0.0;
const double appBarIconWidth = 0.02;
const double appBarIconheight = 0.04;
const double appBarIconPaddingWidth = 0.04;
const double tabTextWidth = 0.05;
const double listTileDivHeight = 0.02;
const double listTileImgHeight = 0.2;
const double listTileImgWidth = 0.2;

List<String> tabViews = ['One', 'Two', 'Three', 'Four'];

List<List<Product>> products = [
  [
    Product('1', 'Apple', imgUrl, '50', dummyDesc),
    Product('2', 'Orange', imgUrl, '150', dummyDesc),
    Product('3', 'Banana', imgUrl, '250', dummyDesc),
    Product('4', 'Apple', imgUrl, '350', dummyDesc),
    Product('5', 'Orange', imgUrl, '450', dummyDesc),
    Product('6', 'Banana', imgUrl, '550', dummyDesc),
  ],
  [
    Product('1', 'Apple', imgUrl, '50', dummyDesc),
    Product('2', 'Orange', imgUrl, '150', dummyDesc),
    Product('3', 'Banana', imgUrl, '250', dummyDesc),
    Product('4', 'Apple', imgUrl, '350', dummyDesc),
    Product('5', 'Orange', imgUrl, '450', dummyDesc),
    Product('6', 'Banana', imgUrl, '550', dummyDesc),
  ],
  [
    Product('1', 'Apple', imgUrl, '50', dummyDesc),
    Product('2', 'Orange', imgUrl, '150', dummyDesc),
    Product('3', 'Banana', imgUrl, '250', dummyDesc),
    Product('4', 'Apple', imgUrl, '350', dummyDesc),
    Product('5', 'Orange', imgUrl, '450', dummyDesc),
    Product('6', 'Banana', imgUrl, '550', dummyDesc),
  ],
  [
    Product('1', 'Apple', imgUrl, '50', dummyDesc),
    Product('2', 'Orange', imgUrl, '150', dummyDesc),
    Product('3', 'Banana', imgUrl, '250', dummyDesc),
    Product('4', 'Apple', imgUrl, '350', dummyDesc),
    Product('5', 'Orange', imgUrl, '450', dummyDesc),
    Product('6', 'Banana', imgUrl, '550', dummyDesc),
  ],
];

//constants end

class Product {
  final String id, name, img, price, desc;
  Product(this.id, this.name, this.img, this.price, this.desc);
}

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    // ignore: prefer_const_constructors
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int indexTab = 0;
  int productWeight = 0;

  @override
  Widget build(BuildContext context) {
    //List<String> proValues = [for (var i in products[indexTab]) '0'];
    var width = MediaQuery.of(context).size.width;
    var height = MediaQuery.of(context).size.height;
    return DefaultTabController(
      length: tabViews.length,
      initialIndex: 0,
      child: Scaffold(
        appBar: AppBar(
            backgroundColor: appBarColor,
            elevation: elevationSize,
            //leading: IconButton(onPressed: () {}, icon: Icon(Icons.account_circle_outlined,color: normalColor,weight: width*appBarIconWidth,size: height*appBarIconheight,)),
            title: Text(
              headName,
              style: TextStyle(
                  color: headColor,
                  fontWeight: headWight,
                  fontSize: width * headFontSize),
            ),
            actions: [
              Row(
                children: [
                  Padding(
                    padding:
                        EdgeInsets.only(right: width * appBarIconPaddingWidth),
                    child: IconButton(
                        onPressed: () {},
                        icon: Icon(
                          Icons.search,
                          color: normalColor,
                          weight: width * appBarIconWidth,
                          size: height * appBarIconheight,
                        )),
                  ),
                  Padding(
                    padding:
                        EdgeInsets.only(right: width * appBarIconPaddingWidth),
                    child: IconButton(
                        onPressed: () {},
                        icon: Icon(
                          Icons.shopping_cart_outlined,
                          color: normalColor,
                          weight: width * appBarIconWidth,
                          size: height * appBarIconheight,
                        )),
                  ),
                  Padding(
                    padding:
                        EdgeInsets.only(right: width * appBarIconPaddingWidth),
                    child: IconButton(
                        onPressed: () {},
                        icon: Icon(
                          Icons.account_circle_outlined,
                          color: normalColor,
                          weight: width * appBarIconWidth,
                          size: height * appBarIconheight,
                        )),
                  ),
                ],
              ),
            ],
            bottom: TabBar(
              onTap: (index) {
                setState(() {
                  indexTab = index;
                });
              },
              tabs: [
                for (var i in tabViews)
                  Text(
                    i,
                    style: TextStyle(
                        fontSize: width * tabTextWidth,
                        color: tabViews.indexOf(i) == indexTab
                            ? tabTextColor
                            : tabTextHideColor),
                  ),
              ],
              dividerColor: tabColor,
              indicatorColor: dividerColors,
            )),
        // drawer: Drawer(
        //   child: IconButton(onPressed: () {}, icon: Icon(Icons.account_circle_outlined,color: normalColor,weight: width*appBarIconWidth,size: height*appBarIconheight,)),
        // ),
        body: TabBarView(children: [
          for (var i in tabViews)
            SingleChildScrollView(
              scrollDirection: Axis.vertical,
              child: Column(
                children: [
                  Column(
                    children: [
                      for (var j in products[tabViews.indexOf(i)])
                        Column(
                          children: [
                            ListTile(
                              title: Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceAround,
                                children: [
                                  Text(j.name),
                                  Row(
                                    children: [
                                      IconButton(
                                        color: amtIncColor,
                                        onPressed: () {
                                          setState(() {
                                            if (productWeight < 25) {
                                              productWeight++;
                                            }
                                          });
                                        },
                                        icon: const Icon(Icons.add),
                                      ),
                                      Text(productWeight
                                          .toString()
                                          .padLeft(2, "0")),
                                      IconButton(
                                        color: amtIncColor,
                                        onPressed: () {
                                          setState(() {
                                            if (productWeight > 0) {
                                              productWeight--;
                                            }
                                          });
                                        },
                                        icon: const Icon(Icons.remove),
                                      ),
                                    ],
                                  )
                                ],
                              ),
                              subtitle:
                                  Text(j.desc, textAlign: TextAlign.justify),
                              leading: Image.network(
                                j.img,
                                width: width * listTileImgWidth,
                                height: height * listTileImgHeight,
                              ),
                              trailing: Text('1KG \nRs: ${j.price}'),
                            ),
                            Divider(
                              height: height * listTileDivHeight,
                            ),
                          ],
                        ),
                      //Text(j.desc),
                    ],
                  )
                ],
              ),
            ),
        ]),
        backgroundColor: backGroundColor,
      ),
    );
  }
}
