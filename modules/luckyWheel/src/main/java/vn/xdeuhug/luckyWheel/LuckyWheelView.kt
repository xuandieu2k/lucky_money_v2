package vn.xdeuhug.luckyWheel

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import vn.xdeuhug.luckywheel.model.LuckyItem
import java.util.Random

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
class LuckyWheelView : RelativeLayout, PieView.PieRotateListener,
    PieView.OnSpinnerListener {
    private var mBackgroundColor = 0
    private var mTextColor = 0
    private var mTopTextSize = 0
    private var mSecondaryTextSize = 0
    private var mBorderColor = 0
    private var mTopTextPadding = 0
    private var mEdgeWidth = 0
    private var mCenterImage: Drawable? = null
    private var mCursorImage: Drawable? = null

    private var pieView: PieView? = null
    private var ivCursorView: ImageView? = null

    private var mLuckyRoundItemSelectedListener: LuckyRoundItemSelectedListener? = null

    private var mOnSpinnerListener: LuckyWheelView.OnSpinnerListener? = null

    interface OnSpinnerListener {
        fun onNotHaveMoney()
    }

    fun setOnSpinnerListener(listener: LuckyWheelView.OnSpinnerListener?) {
        this.mOnSpinnerListener = listener
    }

    override fun rotateDone(index: Int) {
        if (mLuckyRoundItemSelectedListener != null) {
            mLuckyRoundItemSelectedListener!!.LuckyRoundItemSelected(index)
        }
    }

    override fun onHaveNotMoney() {
        mOnSpinnerListener?.onNotHaveMoney()
    }

    interface LuckyRoundItemSelectedListener {
        fun LuckyRoundItemSelected(index: Int)
    }

    fun setLuckyRoundItemSelectedListener(listener: LuckyRoundItemSelectedListener?) {
        this.mLuckyRoundItemSelectedListener = listener
    }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    /**
     * @param ctx
     * @param attrs
     */
    private fun init(ctx: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = ctx.obtainStyledAttributes(attrs, R.styleable.LuckyWheelView)
            mBackgroundColor =
                typedArray.getColor(R.styleable.LuckyWheelView_lkwBackgroundColor, -0x340000)
            mTopTextSize = typedArray.getDimensionPixelSize(
                R.styleable.LuckyWheelView_lkwTopTextSize,
                LuckyWheelUtils.convertDpToPixel(
                    10f,
                    context
                ).toInt()
            )
            mSecondaryTextSize = typedArray.getDimensionPixelSize(
                R.styleable.LuckyWheelView_lkwSecondaryTextSize,
                LuckyWheelUtils.convertDpToPixel(
                    20f,
                    context
                ).toInt()
            )
            mTextColor = typedArray.getColor(R.styleable.LuckyWheelView_lkwTopTextColor, 0)
            mTopTextPadding = typedArray.getDimensionPixelSize(
                R.styleable.LuckyWheelView_lkwTopTextPadding,
                LuckyWheelUtils.convertDpToPixel(
                    10f,
                    context
                ).toInt()
            ) + LuckyWheelUtils.convertDpToPixel(10f, context).toInt()
            mCursorImage = typedArray.getDrawable(R.styleable.LuckyWheelView_lkwCursor)
            mCenterImage = typedArray.getDrawable(R.styleable.LuckyWheelView_lkwCenterImage)
            mEdgeWidth = typedArray.getInt(R.styleable.LuckyWheelView_lkwEdgeWidth, 10)
            mBorderColor = typedArray.getColor(R.styleable.LuckyWheelView_lkwEdgeColor, 0)
            typedArray.recycle()
        }

        val inflater = LayoutInflater.from(context)
        val frameLayout = inflater.inflate(R.layout.lucky_wheel_layout, this, false) as FrameLayout

        pieView = frameLayout.findViewById<PieView>(R.id.pieView)
        ivCursorView = frameLayout.findViewById(R.id.cursorView)
        pieView?.let {
            it.setPieRotateListener(this)
            it.setSpinnerListener(this)
            it.setPieBackgroundColor(mBackgroundColor)
            it.setTopTextPadding(mTopTextPadding)
            it.setTopTextSize(mTopTextSize)
            it.setSecondaryTextSizeSize(mSecondaryTextSize)
            it.setPieCenterImage(mCenterImage)
            it.setBorderColor(mBorderColor)
            it.setBorderWidth(mEdgeWidth)
        }


        if (mTextColor != 0) pieView?.setPieTextColor(mTextColor)

        ivCursorView?.setImageDrawable(mCursorImage)

        addView(frameLayout)
    }


    var isTouchEnabled: Boolean
        get() = pieView?.isTouchEnabled ?: false
        set(touchEnabled) {
            pieView?.isTouchEnabled = (touchEnabled)
        }

    fun setNotHaveMoney(notHaveMoney: Boolean) {
        pieView?.setNotHaveMoney(notHaveMoney)
    }


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        //This is to control that the touch events triggered are only going to the PieView
        for (i in 0 until childCount) {
            if (isPieView(getChildAt(i))) {
                return super.dispatchTouchEvent(ev)
            }
        }
        return false
    }

    private fun isPieView(view: View): Boolean {
        if (view is ViewGroup) {
            for (i in 0 until childCount) {
                if (isPieView(view.getChildAt(i))) {
                    return true
                }
            }
        }
        return view is PieView
    }

    fun setLuckyWheelBackgroundColor(color: Int) {
        pieView?.setPieBackgroundColor(color)
    }

    fun setLuckyWheelCursorImage(drawable: Int) {
        ivCursorView!!.setBackgroundResource(drawable)
    }

    fun setLuckyWheelCenterImage(drawable: Drawable?) {
        pieView?.setPieCenterImage(drawable)
    }

    fun setBorderColor(color: Int) {
        pieView?.setBorderColor(color)
    }

    fun setLuckyWheelTextColor(color: Int) {
        pieView?.setPieTextColor(color)
    }

    /**
     * @param data
     */
    fun setData(data: List<LuckyItem>) {
        pieView?.setData(data)
    }

    /**
     * @param numberOfRound
     */
    fun setRound(numberOfRound: Int) {
        pieView?.setRound(numberOfRound)
    }

    fun setRandomRound() {
        pieView?.setRandomRound()
    }

    /**
     * @param fixedNumber
     */
    fun setPredeterminedNumber(fixedNumber: Int) {
        pieView?.setPredeterminedNumber(fixedNumber)
    }

    fun startLuckyWheelWithTargetIndex(index: Int) {
        pieView?.rotateTo(index)
    }

    fun startLuckyWheelWithRandomTarget() {
        val r = Random()
        pieView?.rotateTo(r.nextInt(pieView?.luckyItemListSize?.minus(1) ?: 0))
    }
}