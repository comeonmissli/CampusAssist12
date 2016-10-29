package com.example.campusassist12.play;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SceneryActivity extends Activity {
	int[] images = new int[] { R.drawable.tengwangge,
			R.drawable.badashanrenjinianguan, R.drawable.hanwangfeng,
			R.drawable.xiangshansenglingongyuan, R.drawable.xishanwanshougong,R.drawable.meiling };
	String[] names = new String[] { "滕王阁", "八大山人纪念馆", "罕王峰", "象山森林公园", "西山万寿宫","梅岭" };
	String[] briefs = new String[] { "江南三大名楼之首", "集收藏、陈列、研究、宣传为一体",
			"青山绿水，风景多彩，盛夏气候凉爽", "避暑、休闲、疗养、度假的最佳场所", "江南著名道教宫观和游览胜地",
			"山势嵯峨，层峦叠翠，四时秀色，气候宜人" };
	String[] contents = new String[] {
			"\t\t滕王阁位于江西省南昌市沿江路赣江与抚河故道交汇处与黄鹤楼、岳阳楼并称为江南三大名楼。1991年被国家旅游局列为\"中国旅游胜地四十佳\"提名单位；2001年1月被国家旅游局授予首批\"国家AAAA级旅游区（点）\"称号，2004年被国务院批准为国家重点风景名胜区。重建后的滕王阁已成了南昌，也是江西省的一处重要的旅游景点。"
					+ "\n\t\t\"江南三大名楼\"之一的腾王阁，屡毁屡建达二十八次之多。新落成的腾王阁，较一千三百多年前的建筑更嵯峨雄壮，充分表现\"飞阁流丹，下临无地\"的气势。投资建造了\"马当神\"号豪华游艇供游客畅游赣江；建造了滕王阁宾馆、贵宾宴会厅、仿古展演厅、名人字画厅等。登楼眺望，南昌景致尽收眼底。"
					+ "\n\t\t滕王阁之所以享有巨大名声，很大程度上归功于一篇脍炙人口的散 文《滕王阁序》。传说当时诗人王勃探亲路过南昌，正赶上阎都督重修 滕王阁后，在阁上大宴宾客，王勃当场一气写下这篇令在座宾客赞服的 《秋日登洪府滕王阁饯别序》（即《滕王阁序》），王勃作序后，又有王仲舒作记，王绪作赋，历史上称为\"三王文章\"。从此，序以阁而闻 名，阁以序而著称。1300多年来，滕五阁历经兴废28次，最后在1926年 被北洋军阀邓如琢部纵火烧毁。"
					+ "\n\t\t苏东坡手书的千古名篇 《滕王阁序》。《滕王阁序》中 最著名的两句是\"落霞与孤鹜齐飞，秋水共长天一色\"。这已作为主阁 正门的巨联。暮秋之后，鄱阳湖区将有成千上万只侯鸟飞临，那将构成 一幅活生生的\"落霞与孤鹜齐飞，秋水共长天一色\"，成为滕王阁的 一大胜景。",
			"\t\t八大山人纪念馆地处南昌市南郊十五华里的青云谱道院内，青云谱道院是一座具有江南地方特色的园林。园林之南部、西部面临宽阔的梅湖，泊岸曲折，水明如镜，独揽湖山田园之美。青云谱园内，苍木翠绿，掩映着殿宇云阁，丹桂碧池，环抱住凉亭月楼，逸静幽雅，宛若仙境。\n\t\t园中现存有关帝、吕祖、许祖三官、斗姆、峤园等六座殿堂，中间以天地相融，东西接庑殿四座，中部鹤巢二间，抬梁式构架，悬山顶、青砖灰瓦的粉墙，精而不华，青而不饰，古朴典雅，风格独具。 ",
			"\t\t梦山胜迹,原名罕王峰，是南昌市一个较大的旅游景区，地处市郊30公里，景区面积15平方公里。青山绿水，风景多彩，盛夏气候凉爽。景区有20多个风景点，是一个美丽的旅游风景胜地和避暑山庄。\n\t\t据历史的记载，三国蜀炎兴元年（263年），蜀汉为晋所灭，昭烈帝刘备之孙刘护，携家从四川来到这里，见山势险要，便傍山结寨距守。其母罗氏，见天下大势不可逆转，劝子归晋，封为广惠王，母封协庆夫人。太康元年（280年），晋灭东吴。东吴余党败走西山藩源，与山贼勾结，拥众万余，焚烧荡空，民受其害。是年九月，刘护率军破贼，因功封罕王，赐所住山峰为罕王峰。刘护之母常感人人梦，俗称\"梦娘娘\"，民间历来有人求梦，遂又称梦山。",
			"\t\t位于赣江中下游的鄱阳湖之滨，与著名的旅游胜地庐山隔湖相望，与世界候鸟保护区鄱阳湖紧连一体，紧紧接壤南昌昌北机场，京九铁路、昌九高速公路从公园擦肩而过，乐昌水泥公路贯通公园全境，处于庐山、鄱阳湖候鸟观赏区、南昌滕王阁旅游带之间，地理位置优越，交通条件便利。\n\t\t公园总面积2.5万亩，森林面积1.8万亩，在茂密葱葱的森林里，每年的3-10月间，相继都有70-80羽鹭鸟在林间栖息、繁衍，不同种类的鹭鸟，分片栖息，麻鹭灰鹭在东片林，大、中、小白鹭在西片林，绿色的池鹭与黄色的苹鹭在南片林，鹭鸟飞时遮天蔽地、站落婷婷玉立、远观群星点点、近望美丽可爱，在江南形成了一大奇观，是南昌市大十景点之一，是全国最大的鹭鸟主要的生息之地，据有关野生动物学者及鸟类专家考证为中国之最。",
			"\t\t西山万寿宫是纪念许真君而修建的一座宫殿。坐落于距南昌市西南三十公里的西山逍遥山下。道教认为除了凡人居住的世界外，还有神仙的处所三十六洞天，七十二福地。许真君栖身修炼的西山则为第四十福地。因他在此仙逝，故又称\"飞升福地\"。公元1520年（明正德十五年），皇帝题额《妙济万寿宫》对宫内建筑作了重大修葺。至清代增建关帝阁、万寿宫门、这时是万寿宫极盛时期，占地三万一千平方米。宫门之内，正殿琉璃为瓦，重檐画栋，金碧辉煌，气势宏伟。绣金帷里，真君塑像端坐中央，坐像头部为黄铜铸成，重500斤。12真人分列两旁，吴猛、郭璞站立坛前。高明殿等三殿之前，6株参天古柏苍老遒劲，四季常青，相传最大一株为许真君亲手所植。宫门左侧的八角井，相传当年许真君铸铁为柱，链钩地脉，以绝水患。宫外还有大量的辅助建筑，如接仙台、云会常、冲升阁等形成一个以万寿宫为中心的古建筑群。远眺西山万寿宫，万顷绿海中，琉璃瓦黄绿相间，绚丽多彩，飞檐串串铜铃，金光闪烁，层层斑澜的宫顶，突兀鹤立，天地氤氲、万物化淳，疑是天上宫阙。铁铸大吊针，重二吨余，入夜钟声宏浑悠扬，能传十里之遥。 农历正有二十七日是许真君诞上辰，为每年小朝；八月仙逝日为朝颧高潮，各地信民薰沐斋戒纷纷前来进香，成千上万的进香者比肩接踵、张袂成荫。他们进入宫后一步一跪拜，到殿前陈敬贡品，晋谒仙颜，祈祷自己的心愿。焚香炉前，鞭炮声不绝不耳，香火明烛通宵达旦，炉烟缥缈，钟声悠扬，一派仙家气氛。",
			"\t\t梅岭风景区位于南昌市西郊。山势嵯峨，层峦叠翠，四时秀色，气候宜人。素有\"小庐山\"之称。 梅岭原名飞鸿山，早在汉朝初年，就辟有驿道。西汉末年，南昌县尉梅福为抵制王莽专政,退隐西郊飞鸿山。后人纪念他的高风亮节，在岭上建梅仙坛，岭下建梅仙观，改飞鸿山为梅岭。唐朝以来，有张九龄、张商英、周必大、王安石、张位五位丞相，欧阳修、曾巩、黄庭坚、陈师道、汤显祖等文学家，岳飞等武将，慕名而来，留下了许多名诗佳作和文人景观。\n\t\t梅岭是佛、道两教的圣地之一，寺庙观坛曾多达136处。道书称此为\"第十二洞天\"。西山八大名刹之首的翟岩寺，原有一尊1.6丈高的曾居云堂寺，8尺高的铜莲台和铜瓶、铜香炉、千僧锅。原道教名刹太平观旁有一株\"千年银杏\"，树高30米，胸围7.5米。位居山巅的紫阳宫，石室尚存，东汉开国元勋邓禹曾到此，旁有邓仙洞和真君墓。梅岭上百座山峰，各具特色。梅岭头翠竹生幽，狮子峰险峻难攀，紫阳山秀丽多姿，罗汉岭利于观景。梅岭有许多古树名木，尤以\"盆景樟\"、\"石中兰\"、\"树生竹\"为奇，被誉为\"梅岭三绝\"。" };
	private ListView myList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//获取下拉列表
		setContentView(R.layout.activity_scenery);
		myList=(ListView) this.findViewById(R.id.sceneryList);
		//内容集合
		ArrayList<Map<String, String>> sceneryList = new ArrayList<Map<String, String>>();
		for(int i=0;i<names.length;i++){
			Map<String,String>sceneryItem=new HashMap<String,String>();
			sceneryItem.put("name", names[i]);
			sceneryItem.put("brief", briefs[i]);
			sceneryItem.put("images", images[i]+"");
			sceneryList.add(sceneryItem);
		}
		SimpleAdapter adapter=new SimpleAdapter(this,sceneryList,R.layout.sceneryitem,
				new String[]{"image","name","brief"},new int[]{R.id.image,R.id.name,R.id.brief});
		myList.setAdapter(adapter);
		myList.setOnItemClickListener(new myOnItemClickListenner());
		
	}
	private class myOnItemClickListenner implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(SceneryActivity.this, SceneryShowActivity.class);
			intent.putExtra("image", images[position]);
			intent.putExtra("content",contents[position]);
			startActivity(intent);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scenery, menu);
		return true;
	}

}
