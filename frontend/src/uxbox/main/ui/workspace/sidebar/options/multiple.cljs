;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/.
;;
;; This Source Code Form is "Incompatible With Secondary Licenses", as
;; defined by the Mozilla Public License, v. 2.0.
;;
;; Copyright (c) 2020 UXBOX Labs SL

(ns uxbox.main.ui.workspace.sidebar.options.multiple
  (:require
   [rumext.alpha :as mf]
   [uxbox.common.geom.shapes :as geom]
   [uxbox.main.ui.workspace.sidebar.options.measures :refer [measure-attrs measures-menu]]
   [uxbox.main.ui.workspace.sidebar.options.fill :refer [fill-attrs fill-menu]]
   [uxbox.main.ui.workspace.sidebar.options.stroke :refer [stroke-attrs stroke-menu]]))


(mf/defc options
  {::mf/wrap [mf/memo]}
  [{:keys [shapes] :as props}]
  (let [ids (map :id shapes)
        measure-values (geom/get-attrs-multi shapes measure-attrs)
        fill-values (geom/get-attrs-multi shapes fill-attrs)
        stroke-values (geom/get-attrs-multi shapes stroke-attrs)]
    [:*
     [:& measures-menu {:ids ids
                        :type :multiple
                        :values measure-values}]
     [:& fill-menu {:ids ids
                    :type :multiple
                    :values fill-values}]
     [:& stroke-menu {:ids ids
                      :type :multiple
                      :values stroke-values}]]))

