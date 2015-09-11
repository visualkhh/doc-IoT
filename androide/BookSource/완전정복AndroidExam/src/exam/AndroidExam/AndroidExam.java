package exam.AndroidExam;

import java.util.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import exam.Data.*;
import exam.Draw.*;
import exam.Input.*;
import exam.Input.Timer;
import exam.Layout.*;
import exam.Network.*;
import exam.Output.*;
import exam.Widget.*;
import exam.activity.*;
import exam.dialog.*;
import exam.external.CalcClient;
import exam.external.NewsController;
import exam.service.*;
import exam.thread.*;

public class AndroidExam extends Activity {
	class Example {
		Example(Class<?> acls, String aTitle) {
			cls = acls;
			Title = cls.getSimpleName() + " : " + aTitle;
		}
		String Title;
		Class<?> cls;
	}
	
	Example[][] arExample = {
		{	// Layout
			new Example(TextViewTest.class, "텍스트 뷰"),
			new Example(ImageViewTest.class, "이미지 뷰"),
			new Example(ButtonEdit.class, "버튼과 에디트"),
			new Example(Horizontal.class, "버튼 에디트 수평 배치"),
			new Example(Horizontal2.class, "텍스트 수평 배치"),
			new Example(Horizontal3.class, "텍스트 수평 배치2"),
			new Example(Gravity1.class, "디폴트 좌상단"),
			new Example(Gravity2.class, "화면 중앙"),
			new Example(Gravity3.class, "수직만 중앙"),
			new Example(Gravity4.class, "수직 중앙,수평 오른쪽"),
			new Example(lGravity1.class, "수평중앙"),
			new Example(lGravity2.class, "화면중앙"),
			new Example(lGravity3.class, "두 컨트롤 화면중앙"),
			new Example(lGravity4.class, "두 속성 차이 연구"),
			new Example(Base1.class, "베이스 정렬"),
			new Example(Base2.class, "베이스 안정렬"),
			new Example(Weight1.class, "1:3:1"),
			new Example(Weight2.class, "1:2:3"),
			new Example(Weight3.class, "삼단 분할"),
			new Example(Padding1.class, "디폴트"),
			new Example(Padding2.class, "마진 10"),
			new Example(Padding3.class, "마진 10, 패딩 10"),
			new Example(Relative1.class, "상대적 배치"),
			new Example(NameCard.class, "명함철"),
			new Example(Absolute.class, "절대 배치"),
			new Example(Frame.class, "겹쳐서 배치"),
			new Example(Table.class, "테이블 배치"),
			new Example(NestLayout.class, "레이아웃 중첩"),
			new Example(MultiPage.class, "여러 페이지"),
			new Example(CodeLayout.class, "코드 없음"),
			new Example(CodeLayout2.class, "코드 작성"),
			new Example(Inflation.class, "레이아웃 전개"),
			new Example(Inflation2.class, "코드로 생성"),
			new Example(Inflation3.class, "직접 전개"),
			new Example(Inflation4.class, "텍스트만 전개"),
			new Example(LayoutParameter.class, "레이아웃 전개"),
			new Example(LayoutParameter2.class, "코드로 생성"),
			new Example(MarginParameter.class, "마진 주기"),
			new Example(MarginParameter2.class, "코드로 생성"),
		},
		{	// Ouput
			new Example(CustomView.class, "커스텀 뷰"),
			new Example(Primitive1.class, "기본 도형"),
			new Example(Primitive2.class, "기본 도형2"),
			new Example(AntiAlias.class, "안티 알리아싱"),
			new Example(PaintTest.class, "Paint 객체"),
			new Example(DrawBitmap.class, "비트맵 출력"),
			new Example(DrawText.class, "텍스트 출력"),
			new Example(TypeFace.class, "타입 페이스"),
			new Example(CustomFont.class, "커스텀 폰트"),
			new Example(DrawPath.class, "패스 출력"),
			new Example(ToastTest.class, "토스트 출력"),
			new Example(MessageBeep.class, "비프음"),
			new Example(SoundPoolTest.class, "사운드 풀"),
		},
		{	// Input
			new Example(HandleEvent.class, "여러 가지 이벤트 처리 방식"),
			new Example(HandlerOrder.class, "핸들러의 우선 순위"),
			new Example(HandlerAccess.class, "외부 변수 액세스"),
			new Example(FreeLine.class, "자유 곡선"),
			new Example(MoveCircle.class, "키보드로 원 움직이기"),
			new Example(Fruit.class, "위젯의 이벤트 처리"),
			new Example(FocusTest.class, "포커스 이동(디폴트)"),
			new Example(FocusTest2.class, "포커스 이동(순환)"),
			new Example(Timer.class, "타이머"),
			new Example(OptionMenu.class, "옵션 메뉴"),
			new Example(OptionMenu2.class, "XML로 메뉴 전개"),
			new Example(MenuCheck.class, "메뉴 항목 관리"),
			new Example(ContextMenuTest.class, "컨텍스트 메뉴"),
			new Example(MemoryPower.class, "기억력 게임"),
			new Example(LogTest.class, "Log 남기기"),
			new Example(MemoryPower2.class, "디버깅 실습"),			
		},
		{	// Widget
			new Example(ReadResource.class, "리소스 읽기"),
			new Example(ReadResource2.class, "리소스 읽기2"),
			new Example(StyleTest.class, "스타일"),
			new Example(ThemeTest.class, "테마"),
			new Example(SystemTheme.class, "시스템 테마"),
			new Example(LandPort.class, "대체 리소스"),
			new Example(TextViewAttr.class, "텍스트 뷰의 속성"),
			new Example(SpannableTest.class, "Spannable"),
			new Example(EditableTest.class, "Editable"),
			new Example(TextChange.class, "텍스트 변경 이벤트"),
			new Example(EditLimit.class, "입력 길이 제한"),
			new Example(EditSelect.class, "선택 영역 관리"),
			new Example(InputType.class, "키보드의 종류"),
			new Example(ShowHideKey.class, "키보드 보이기/숨기기"),
			new Example(AdjustKey1.class, "키보드 Panning"),
			new Example(AdjustKey2.class, "키보드 Resize"),
			new Example(NoNinePatch.class, "보통 이미지 배경 사용"),
			new Example(NinePatch.class, "나인패치 이미지 배경 사용"),
			new Example(ArrowButton.class, "화살표 버튼"),
			new Example(RadioTest.class, "라디오 버튼, 체크 박스"),
			new Example(ImageButtonTest.class, "이미지 버튼"),
			new Example(ListTest.class, "리스트 뷰에 문자열 출력"),
			new Example(ListFromArray.class, "리스트 뷰에 XML 배열 출력"),
			new Example(ListAttr.class, "리스트 뷰의 속성"),
			new Example(ListAddDel.class, "리스트의 항목 편집"),
			new Example(ListIconText.class, "아이콘과 텍스트 같이 출력"),
			new Example(ListOfViews.class, "여러 종류의 뷰 출력"),
			new Example(ListOnly.class, "ListActivity 사용"),
			new Example(SpinnerTest.class, "스피너"),
			new Example(GridTest.class, "그리드 뷰"),
			new Example(GalleryTest.class, "갤러리 뷰"),
			new Example(ProgressBarTest.class, "프로그래스 바"),
			new Example(ProgressTitle.class, "타이틀 프로그래스"),
			new Example(ProgressTitle2.class, "타이틀 프로그래스"),
			new Example(SeekBarTest.class, "시크 바"),
			new Example(Rating.class, "래이팅 바"),
			new Example(SoundEdit.class, "소리나는 에디트"),
			new Example(NumEdit.class, "입력문자수를 표시"),
			new Example(Attribute.class, "속성 연구"),
			new Example(SoundEdit2.class, "소리나는 에디트2"),
			new Example(Measuring.class, "onMeasure 테스트"),
			new Example(RainbowTest.class, "무지개 프로그래스"),
			new Example(ScrollViewTest.class, "스크롤 뷰"),
			new Example(HScrollViewTest.class, "수평 스크롤 뷰"),
			new Example(WebViewTest.class, "웹 뷰"),			
		},
		{	// Data
			new Example(FileIO.class, "파일 입출력"),
			new Example(ShareFile.class, "파일 공유"),
			new Example(SDCard.class, "SD Card 입출력"),
			new Example(TextLogTest.class, "텍스트 로그"),
			new Example(PrefTest.class, "프레프런스"),
			new Example(PrefActivity.class, "프레프런스 액티비티"),
			new Example(EnglishWord.class, "DB 예제"),
			new Example(ProductList.class, "커서와 연결된 리스트 뷰"),
			new Example(CallWordCP.class, "CP 호출"),			
		},
		{	// activity
			new Example(CallActivity.class, "내부 액티비티 호출"),
			new Example(CallOther.class, "외부 액티비티 호출"),
			new Example(CommActivity.class, "액티비티간의 통신"),
			new Example(SaveState.class, "상태 저장-저장안함"),
			new Example(SaveState2.class, "상태 저장-x만"),
			new Example(SaveState3.class, "상태 저장-x,y 모두"),
			new Example(SaveCurve.class, "곡선 객체 저장"),
			new Example(SaveCurve2.class, "Parcel 저장"),
			new Example(SaveCurve3.class, "액티비티 파괴 금지"),
			new Example(TabTest.class, "탭-뷰의 id 지정"),
			new Example(TabTest2.class, "탭-팩토리"),
			new Example(TabTest3.class, "탭-액티비티"),
			new Example(CustomTab.class, "탭-커스텀"),			
		},
		{	// dialog
			new Example(DialogTest.class, "대화상자"),
			new Example(DialogButton.class, "대화상자 닫기 버튼"),
			new Example(Cancelable.class, "Back 버튼 금지"),
			new Example(ShowDialog.class, "대화상자 미리 생성"),
			new Example(ErrorMessage1.class, "에러 메시지 출력-안보임"),
			new Example(ErrorMessage2.class, "에러 메시지 출력-보임"),
			new Example(Question1.class, "질문하기 - 1단계"),
			new Example(Question2.class, "질문하기 - 3단계"),
			new Example(SelectDialog1.class, "목록 선택"),
			new Example(SelectDialog2.class, "단일 선택 대화상자"),
			new Example(SelectDialog3.class, "복수 선택 대화상자"),
			new Example(OrderDialog.class, "상품 주문 대화상자"),
			new Example(PopupTest.class, "팝업 테스트"),			
		},
		{	// thread
			new Example(ThreadTest.class, "스레드"),
			new Example(HandlerTest.class, "핸들러"),
			new Example(LooperTest.class, "루퍼"),
			new Example(Upload.class, "대화상자가 사라지지 않음"),
			new Example(Post.class, "작업 등록 후 즉시 리턴"),
			new Example(ANR.class, "ANR 문제"),
			new Example(ANR2.class, "ANR 해결"),
			new Example(LongTime.class, "긴 작업(블로킹)"),
			new Example(LongTime2.class, "핸들러로 작업 경과 표시"),
			new Example(LongTime3.class, "프로그래스로 경과 표시 및 취소"),
			new Example(LongTime4.class, "스레드 사용"),
			new Example(LongTime5.class, "AsyncTask 사용"),
			new Example(BackWork.class, "백그라운드 작업"),
			new Example(BackWork2.class, "백그라운드 작업-스레드"),
			new Example(BackWork3.class, "백그라운드 작업-대기 스레드"),			
		},
		{	// Draw
			new Example(LinearGrad.class, "직선 그래디언트"),
			new Example(RadialGrad.class, "원형 그래디언트"),
			new Example(SweepGrad.class, "원주 그래디언트"),
			new Example(BitmapSdr.class, "비트맵 셰이더"),
			new Example(ComposeSdr.class, "조합 셰이더"),
			new Example(ShapeTest.class, "셰이프"),
			new Example(BlurFlt.class, "블러 필터"),
			new Example(EmbossFlt.class, "임보싱 필터"),
			new Example(ColorFlt.class, "색상 필터"),
			new Example(ColorM.class, "이미지 반전"),
			new Example(GrayScale.class, "그레이 스케일"),
			new Example(Porter.class, "Porter, Duff의 색상 변환 규칙"),
			new Example(DashPathEft.class, "선 모양 변경"),
			new Example(CornerPathEft.class, "모서리 변경"),
			new Example(PathDashEft.class, "화살표 모양 대시"),
			new Example(DashAnim.class, "대시 애니메이션"),
			new Example(Xfer.class, "Xfermode"),
			new Example(Dither.class, "디더링"),
			new Example(Translate.class, "이동 변환"),
			new Example(Translate2.class, "문자열 연속 출력"),
			new Example(SaveCanvas.class, "캔버스 상태 저장"),
			new Example(Skew.class, "기울이기"),
			new Example(Scale.class, "확대"),
			new Example(TransOrder.class, "변환의 순서"),
			new Example(Rotate.class, "회전 변환"),
			new Example(FrameAni.class, "프레임 애니메이션"),
			new Example(Tween.class, "트윈 애니메이션"),
			new Example(TweenListener.class, "연속 애니메이션"),
			new Example(Reflection.class, "SurfaceView 연구"),
			new Example(Reflection2.class, "SurfaceView 연구"),
			new Example(ReDraw1.class, "느린 그리기"),
			new Example(ReDraw2.class, "객체 미리 생성"),
			new Example(ReDraw3.class, "클리핑 최소화"),
			new Example(ReDraw4.class, "지연된 그리기"),
			new Example(ReDraw5.class, "비트맵 배경 사용"),			
		},
		{	// Network
			new Example(ConMgr.class, "연결 관리자"),
			new Example(DownHtml.class, "HTML 다운로드"),
			new Example(AsyncDownHtml.class, "비동기 다운로드"),
			new Example(DownImage.class, "이미지 다운로드"),
			new Example(WebService.class, "트위터"),
			new Example(DomParser.class, "DOM 파서"),
			new Example(DomParser2.class, "DOM으로 속성 읽기"),
			new Example(SaxParser.class, "SAX 파서"),
			new Example(PullParser.class, "PULL 파서"),
			new Example(JSONArrayTest.class, "JSON 배열 읽기"),
			new Example(JSONObjectTest.class, "JSON 객체 읽기"),			
		},
		{	// service
			new Example(NapAlarm.class, "낮잠 시계"),
			new Example(CustomNotiView.class, "커스텀 통지 뷰"),
			new Example(DetectFree.class, "공짜 네트워크 발견"),
			new Example(DetectSaveZone.class, "할인 지역 발견"),
			new Example(OnSaveZone.class, "할인 지역 감시"),
			new Example(WatchBattery.class, "배터리 감시"),
			new Example(WatchSdcard.class, "SdCard 감시"),
			new Example(AlarmTest.class, "알람 테스트"),
			new Example(NewsController.class, "뉴스 보기"),
			new Example(CalcClient.class, "서비스로 연산"),			
		},
		{	// external
			new Example(NewsController.class, "뉴스 보기"),
			new Example(CalcClient.class, "서비스로 연산"),			
		},
	};
	
	String[] arPackage = {
		"3장 레이아웃(Layout)",
		"4장 출력(Output)",
		"5장, 6장 입력, 메뉴(Input)",
		"7~9장 위젯(Widget)",
		"10장 자료 관리(Data)",
		"11장 액티비티(activity)",
		"12장 대화상자(dialog)",
		"13장 스레드(thread)",
		"14장 고급 그리기(Draw)",
		"15장 네트워크(Network)",
		"16장 서비스service)",
		"외부 패키지(external)",
	};
	ArrayAdapter<CharSequence> mAdapter;
	int mPackage;
	ListView mListActivity;
	Spinner mSpin;
	boolean mInitSelection = true;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.androidexam);

		mListActivity = (ListView)findViewById(R.id.listactivity);
		mSpin = (Spinner)findViewById(R.id.spinnerpackage);
		mSpin.setPrompt("패키지를 선택하세요.");

		mAdapter = new ArrayAdapter<CharSequence>(this, 
				android.R.layout.simple_spinner_item, arPackage);
		mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpin.setAdapter(mAdapter);

		mSpin.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (mInitSelection) {
					mInitSelection = false;
					SharedPreferences pref = getSharedPreferences("AndroidExam", 0);
					int lastpackage = pref.getInt("LastPackage", 0);
					mSpin.setSelection(lastpackage);
					ChangePackage(lastpackage);
				} else {
					ChangePackage(position);
					SharedPreferences pref = getSharedPreferences("AndroidExam", 0);
					SharedPreferences.Editor edit = pref.edit();
					edit.putInt("LastPackage", position);
					edit.commit();
				}
			}
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		// 특정 예제를 반복적으로 수정 및 테스트할 때는 아래 주석문을 활용하십시오.
		// startActivity(new Intent(this, LinearGrad.class));
	}
	
	public void ChangePackage(int Package) {
		mPackage = Package;

		ArrayList<String> arTitle = new ArrayList<String>();
		for (Example e : arExample[mPackage]) {
			arTitle.add(e.Title);
		}
		ArrayAdapter<String> Adapter;
		Adapter = new ArrayAdapter<String>(this, R.layout.mainlist, arTitle);

		mListActivity.setAdapter(Adapter);

		final Context ctx = this;
		mListActivity.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(ctx, arExample[mPackage][position].cls);
				startActivity(intent);
			}
		});
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
	
		menu.add(0,1,0,"소개");
		menu.add(0,2,0,"종료");

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
    		new AlertDialog.Builder(this)
    		.setTitle("프로그램 소개")
    		.setMessage("안드로이드 프로그래밍 정복(한빛미디어)의 예제 모음 프로그램입니다.\n" +
    				"상단의 스피너에서 패키지를 선택하고 목록에서 예제를 선택하십시오.")
    		.setIcon(R.drawable.icon)
    		.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
				}
			})
    		.show();
			return true;
		case 2:
			finish();
			System.exit(0);
			return true;
		}
		return false;
	}
}