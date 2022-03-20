package kr.ac.tuk.simritest.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import kotlinx.android.synthetic.main.fragment_result.*
import kr.ac.tuk.simritest.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    var option = -1

    lateinit var navController: NavController

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        option = arguments?.getInt("index")?:-1

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        setResult(option)


        btn_home.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment2)
        }
    }

    fun setResult(option : Int){

        when(option){
            1 -> {
                tv_main.text = "당신은 잘 포기하는\n타입입니다!"
                tv_sub.text ="너무 사랑을 쉽게 포기하고 계시지는 않나요..."
            }

            2 -> {
                tv_main.text="당신은 자신에게\n집중해야합니다!"
                tv_sub.text="전 애인에게 너무 집착하지는 않나요..."

            }

            3-> {
                tv_main.text="쉽게쉽게\n생각하셔야합니다!"
                tv_sub.text="당신은 어떤 대가를 치뤄야 한다 해도 미친짓을 할 수 있습니다."
            }

            4-> {
                tv_main.text="당신은 꽤 어른스럽군요!"
                tv_sub.text="당신은 헤어짐에 보다 담담한 타입입니다."
            }
        }
    }
}
